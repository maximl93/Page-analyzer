package hexlet.code.repository;

import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Map;
import java.util.LinkedHashMap;


public class UrlsRepository extends BaseRepository {
    private static final String SAVE_URL = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
    private static final String FIND_BY_NAME = "SELECT * FROM urls WHERE name = ?";
    private static final String FIND_BY_ID = "SELECT * FROM urls WHERE id = ?";
    private static final String GET_URLS_AND_CHECKS =
            "SELECT urls.id, urls.name, checks.status_code, checks.created_at "
            + "FROM urls "
            + "LEFT JOIN (SELECT DISTINCT ON (url_id) * FROM url_checks "
            + "ORDER BY url_id, created_at DESC) as checks "
            + "ON urls.id = checks.url_id "
            + "ORDER BY urls.id";

    public static void save(Url url) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(SAVE_URL, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, url.getName());
            LocalDateTime createdAt = LocalDateTime.now();
            prepStatement.setTimestamp(2, Timestamp.valueOf(createdAt));
            prepStatement.executeUpdate();
            ResultSet generatedKeys = prepStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
                url.setCreatedAt(createdAt);
            } else {
                throw new SQLException("");
            }
        }
    }

    public static Optional<Url> findByName(String urlName) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, urlName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(savedUrl(resultSet));
            }
            return Optional.empty();
        }
    }

    public static Optional<Url> findById(long id) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(savedUrl(resultSet));
            }
            return Optional.empty();
        }
    }

    public static Map<Url, UrlCheck> findAllUrlsAndLastUrlsChecks() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_URLS_AND_CHECKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<Url, UrlCheck> result = new LinkedHashMap<>();
            while (resultSet.next()) {
                savedUrlsAndChecks(result, resultSet);
            }
            return result;
        }
    }

    private static Url savedUrl(ResultSet resultSet) throws SQLException {
        Url url = new Url(resultSet.getString("name"));
        url.setId(resultSet.getLong("id"));
        if (resultSet.getTimestamp("created_at") == null) {
            url.setCreatedAt(null);
        } else {
            url.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        }
        return url;
    }

    private static void savedUrlsAndChecks(Map<Url, UrlCheck> result, ResultSet resultSet) throws SQLException {
        Url savedUrl = new Url(resultSet.getString("name"));
        savedUrl.setId(resultSet.getLong("id"));
        UrlCheck lastUrlCheck = new UrlCheck(resultSet.getInt("status_code"), resultSet.getLong("id"));
        if (resultSet.getTimestamp("created_at") == null) {
            lastUrlCheck.setCreatedAt(null);
        } else {
            lastUrlCheck.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        }
        result.put(savedUrl, lastUrlCheck);
    }
}

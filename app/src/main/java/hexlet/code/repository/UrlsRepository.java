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
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;


public class UrlsRepository extends BaseRepository {
    public static void save(Url url) throws SQLException {
        String sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, url.getName());
            LocalDateTime createdAt = LocalDateTime.now();
            preparedStatement.setTimestamp(2, Timestamp.valueOf(createdAt));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                url.setId(generatedKeys.getLong(1));
                url.setCreatedAt(createdAt);
            } else {
                throw new SQLException("");
            }
        }
    }

    public static Optional<Url> findSavedUrlByName(String urlName) throws SQLException {
        String sql = "SELECT * FROM urls WHERE name = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, urlName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Url foundUrl = new Url(urlName);
                foundUrl.setId(resultSet.getLong("id"));
                foundUrl.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                return Optional.of(foundUrl);
            }
            return Optional.empty();
        }

    }

    public static Optional<Url> findSavedUrlById(long id) throws SQLException {
        String sql = "SELECT * FROM urls WHERE id = ?";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Url foundUrl = new Url(resultSet.getString("name"));
                foundUrl.setId(resultSet.getLong("id"));
                foundUrl.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                return Optional.of(foundUrl);
            }
            return Optional.empty();
        }
    }

    public static void saveUrlCheck(UrlCheck check) throws SQLException {
        String sql = "INSERT INTO url_checks (url_id, status_code, h1, title, description, created_at) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, check.getUrlId());
            preparedStatement.setInt(2, check.getStatusCode());
            preparedStatement.setString(3, check.getH1());
            preparedStatement.setString(4, check.getTitle());
            preparedStatement.setString(5, check.getDescription());
            LocalDateTime createdAt = LocalDateTime.now();
            preparedStatement.setTimestamp(6, Timestamp.valueOf(createdAt));
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                check.setId(generatedKeys.getLong(1));
                check.setCreatedAt(createdAt);
            } else {
                throw new SQLException("");
            }
        }
    }

    public static List<UrlCheck> getAllUrlChecks(long urlId) throws SQLException {
        String sql = "SELECT * FROM url_checks WHERE url_id = ? ORDER BY id DESC";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, urlId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UrlCheck> allUrlChecks = new ArrayList<>();
            while (resultSet.next()) {
                UrlCheck check = new UrlCheck(resultSet.getInt("status_code"), resultSet.getLong("url_id"));
                check.setId(resultSet.getLong("id"));
                check.setH1(resultSet.getString("h1"));
                check.setTitle(resultSet.getString("title"));
                check.setDescription(resultSet.getString("description"));
                check.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                allUrlChecks.add(check);
            }
            return allUrlChecks;
        }
    }

    public static Map<Url, UrlCheck> getAllUrlsAndLastUrlsChecks() throws SQLException {
        String sql = "SELECT urls.id, urls.name, checks.status_code, checks.created_at "
                + "FROM urls "
                + "LEFT JOIN (SELECT DISTINCT ON (url_id) * FROM url_checks "
                + "ORDER BY url_id, created_at DESC) as checks "
                + "ON urls.id = checks.url_id "
                + "ORDER BY urls.id";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Map<Url, UrlCheck> result = new LinkedHashMap<>();
            while (resultSet.next()) {
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
            return result;
        }
    }
}

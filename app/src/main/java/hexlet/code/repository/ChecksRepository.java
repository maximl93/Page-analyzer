package hexlet.code.repository;

import hexlet.code.model.UrlCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChecksRepository extends BaseRepository {
    private static final String SAVE_CHECK = "INSERT INTO url_checks "
            + "(url_id, status_code, h1, title, description, created_at) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET_URL_CHECKS = "SELECT * FROM url_checks WHERE url_id = ? ORDER BY id DESC";

    public static void save(UrlCheck check) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(SAVE_CHECK, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setLong(1, check.getUrlId());
            prepStatement.setInt(2, check.getStatusCode());
            prepStatement.setString(3, check.getH1());
            prepStatement.setString(4, check.getTitle());
            prepStatement.setString(5, check.getDescription());
            LocalDateTime createdAt = LocalDateTime.now();
            prepStatement.setTimestamp(6, Timestamp.valueOf(createdAt));
            prepStatement.executeUpdate();
            ResultSet generatedKeys = prepStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                check.setId(generatedKeys.getLong(1));
                check.setCreatedAt(createdAt);
            } else {
                throw new SQLException("");
            }
        }
    }

    public static List<UrlCheck> findByUrlId(long urlId) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_URL_CHECKS);
            preparedStatement.setLong(1, urlId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UrlCheck> allUrlChecks = new ArrayList<>();
            while (resultSet.next()) {
                allUrlChecks.add(savedCheck(resultSet));
            }
            return allUrlChecks;
        }
    }

    public static UrlCheck savedCheck(ResultSet resultSet) throws SQLException {
        UrlCheck check = new UrlCheck(resultSet.getInt("status_code"), resultSet.getLong("url_id"));
        check.setId(resultSet.getLong("id"));
        check.setH1(resultSet.getString("h1"));
        check.setTitle(resultSet.getString("title"));
        check.setDescription(resultSet.getString("description"));
        if (resultSet.getTimestamp("created_at") == null) {
            check.setCreatedAt(null);
        } else {
            check.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        }
        return check;
    }
}

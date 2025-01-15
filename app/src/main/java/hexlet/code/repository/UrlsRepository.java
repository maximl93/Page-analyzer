package hexlet.code.repository;

import hexlet.code.model.Url;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UrlsRepository extends BaseRepository{
    public static void save(Url url) throws SQLException {
        String sql = "INSERT INTO urls (name, created_at) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection()){
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

    public static List<Url> getAllUrls() throws SQLException {
        String sql = "SELECT * FROM urls";
        try (Connection connection = dataSource.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); //переименовать
            List<Url> allSavedUrls = new ArrayList<>();
            while (resultSet.next()) {
                Url savedUrl = new Url(resultSet.getString("name"));
                savedUrl.setId(resultSet.getLong("id"));
                savedUrl.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                allSavedUrls.add(savedUrl);
            }
            return allSavedUrls;
        }
    }

    public static Optional<Url> findSavedUrlByName(String urlName) throws SQLException {
        String sql = "SELECT * FROM urls WHERE name = ?";
        try (Connection connection = dataSource.getConnection()){
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
        try (Connection connection = dataSource.getConnection()){
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
}

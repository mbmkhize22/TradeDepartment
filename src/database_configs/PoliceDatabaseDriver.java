package database_configs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trade_department.Police;


public class PoliceDatabaseDriver {

    public PoliceDatabaseDriver() {
        createPoliceTable();
    }

    private void createPoliceTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Police (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER NOT NULL,
                badgeNumber TEXT NOT NULL
            );
        """;

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPolice(Police police) {
        String insertSQL = "INSERT INTO Police (name, age, badgeNumber) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, police.getName());
            statement.setInt(2, police.getAge());
            statement.setString(3, police.getBadgeNumber());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Police getPoliceById(int id) {
        String selectSQL = "SELECT * FROM Police WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectSQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Police(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("badgeNumber")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Police> getAllPolice() {
        List<Police> policeList = new ArrayList<>();
        String selectAllSQL = "SELECT * FROM Police";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(selectAllSQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                policeList.add(new Police(
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("badgeNumber")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policeList;
    }

    public void updatePolice(int id, Police police) {
        String updateSQL = "UPDATE Police SET name = ?, age = ?, badgeNumber = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            statement.setString(1, police.getName());
            statement.setInt(2, police.getAge());
            statement.setString(3, police.getBadgeNumber());
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePolice(int id) {
        String deleteSQL = "DELETE FROM Police WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

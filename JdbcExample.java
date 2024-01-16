import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) {
        // JDBC connection parameters for MySQL
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_url"; // Replace with your MySQL database URL
        String username = "root";
        String password = "batmanop";

        // Sample data for insertion
        String name = "John Doe";
        int age = 25;
        String city = "Example City";

        // Establishing a connection and creating a new database
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to the database.");

            // Creating a new database
            createDatabase(connection, "your_database_url"); // Replace with your desired database name

            // Switch to the newly created database
            connection.setCatalog("your_database_url"); // Replace with your desired database name

            // Creating a table in the database
            createTable(connection);

            // Inserting data into the table
            insertData(connection, name, age, city);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new database
    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + databaseName;

        try (Statement statement = connection.createStatement()) {
            statement.execute(createDatabaseSQL);
            System.out.println("Database created (if not exists).");
        }
    }

    // Method to create a table in the database
    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255), age INT, city VARCHAR(255))";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table created (if not exists).");
        }
    }

    // Method to insert data into the table
    private static void insertData(Connection connection, String name, int age, String city) throws SQLException {
        String insertDataSQL = "INSERT INTO users (name, age, city) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, city);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Data inserted into the table successfully.");
            } else {
                System.out.println("Failed to insert data into the table.");
            }
        }
    }
}

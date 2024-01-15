package Assignments_Java;

import java.sql.*;

public class task10 {

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/my_database";
    private static final String USERNAME = "my_username";
    private static final String PASSWORD = "my_password";

    // JDBC objects
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public task10() {
        try {
            // Establish database connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create a statement
            statement = connection.createStatement();

            // Execute queries or updates as needed
            createUsersTable(); // Create a users table if not exists

            // Example: Insert a student details into the database
            insertUser("Koushik Das", "k@gmail.com", "password123");

            // Example: Retrieve and display user details
            displayUserDetails("k@gmail.com");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            closeResources();
        }
    }

    private void createUsersTable() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "email VARCHAR(255) UNIQUE," +
                "password VARCHAR(255)" +
                ")";
        statement.executeUpdate(createTableSQL);
    }

    private void insertUser(String name, String email, String password) throws SQLException {
        String insertUserSQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
        }
    }

    private void displayUserDetails(String email) throws SQLException {
        String selectUserSQL = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectUserSQL)) {
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();

            // Display user details
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Email: " + resultSet.getString("email"));
                // You can retrieve other user details as needed
            }
        }
    }

    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new task10();
    }
}


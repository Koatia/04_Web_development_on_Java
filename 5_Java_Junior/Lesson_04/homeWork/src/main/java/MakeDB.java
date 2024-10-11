import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MakeDB {

    public static void prepareDB() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "admin";

        // Подключение к базе данных
        Connection connection = DriverManager.getConnection(url, user, password);

        // Создание базы данных
        createDatabase(connection);
        System.out.println("Database created successfully");

        // Использование базы данных
        useDatabase(connection);
        System.out.println("Use database successfully");

        // Создание таблицы
        createTable(connection);
        System.out.println("Create table successfully");

        // Закрытие соединения
        connection.close();
        System.out.println("Preparation of the database has been completed successfully");
    }

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS SchoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE SchoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL =
                "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), duration INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }
}

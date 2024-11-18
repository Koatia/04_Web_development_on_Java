package example1;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void con() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();
            statement.execute("CREATE DATABASE IF NOT EXISTS `test`;");
            statement.execute("CREATE TABLE IF NOT EXISTS `test`.`table` (\n" +
                    " `id` INT NOT NULL,\n" +
                    " `firstname` VARCHAR(45) NULL,\n" +
                    " `lastname` VARCHAR(45) NULL,\n" +
                    " PRIMARY KEY (`id`));");
            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
                    "VALUES (1,'Иванов','Иван');");
            statement.execute("INSERT INTO `test`.`table` (`id`,`firstname`,`lastname`)\n" +
                    "VALUES (2,'Петров','Пётр');");

            ResultSet set = statement.executeQuery("SELECT * FROM `test`.`table`");
            while (set.next()) {
                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;
    }

}

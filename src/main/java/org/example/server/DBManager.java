package org.example.server;

import java.sql.*;
import java.sql.PreparedStatement;

public class DBManager {
    private Connection connection = null;
    private Statement statement;

    public DBManager() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/java/org/example/resources/sqlite_db.s3db");
            if (connection != null) {
                System.out.println("Соединение установлено!");
                statement = connection.createStatement();
                addRecords();
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println("Error!");
        }
    }

    private void addRecords() {
        try {

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public String getNickByLoginAndPass(String login, String password) throws SQLException {
        try (final PreparedStatement preparedStatement = connection.prepareStatement("select nickname from users(login, password) VALUES (" + login + ", " + password + ")"){
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, Integer.parseInt(password));
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d - %s - %d\n", resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }
        }
    }




    public void changeNick(String oldNick, String newNick) {
        try {
            statement.executeUpdate("update 'users' set nickname=\""+newNick+"\" where nickname=\""+oldNick+"\"");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

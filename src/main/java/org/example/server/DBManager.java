package org.example.server;

import java.sql.*;

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
            System.out.println("Ошибка!");
        }
    }

    private void addRecords() {
        try {

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public String getNickByLoginAndPass(String login, String password) {
        String nick;
        try {
            ResultSet resultSet = statement.executeQuery("select nickname from users where login=\"" + login + "\" and password=\"" + password + "\"");
            nick = resultSet.getString(1);
            return nick;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }

    public void changeNick(String oldNick, String newNick) {
        try {
            statement.executeUpdate("update 'users' set nickname=\""+newNick+"\" where nickname=\""+oldNick+"\"");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}

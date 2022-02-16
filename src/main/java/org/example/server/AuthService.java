package org.example.server;

import java.sql.SQLException;

public interface AuthService {
    void start();

    void stop();

    String getNickByLoginAndPass(String login, String password) throws SQLException;
}

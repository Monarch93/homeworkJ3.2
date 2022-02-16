package org.example.server;

import java.sql.SQLException;

public class BaseAuthService implements AuthService {
    private DBManager dbManager;

    public BaseAuthService(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public void start() {
        System.out.println("Сервис авторизации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис авторизации остановлен");
    }

    @Override
    public String getNickByLoginAndPass(String login, String password) throws SQLException {
        return dbManager.getNickByLoginAndPass(login, password);
    }
}

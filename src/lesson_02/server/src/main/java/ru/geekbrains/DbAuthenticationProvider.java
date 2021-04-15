package ru.geekbrains;

import java.sql.*;

public class DbAuthenticationProvider implements AuthenticationProvider {
    private static Connection connection;
    private static Statement stmt;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:authdb.db");
            stmt = connection.createStatement();
            System.out.println("Есть подключение");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Невозможно подключиться к БД");
        }
    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {

        try (ResultSet rs = stmt.executeQuery("select nickname from users where login = '" + login + "'" +
                "  and password = '" + password + "';")) {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeNickname(String oldNickname, String newNickname) {
        try {
            // такой пользователь с таким никнеймом точно есть в базе, он же авторизован
            // и новый никнейм не занят, проверили в ClientHandler (но только онлайн а не в БД,
            // и поэтому можно брать никнейм тех, то не онлайн, недоработка. Надо искать по базе).
            // изменяем никнейм без проверок здесь на новый

            stmt.executeUpdate("update users set nickname = '" + newNickname + "' where nickname = '" +
                    oldNickname + "';");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


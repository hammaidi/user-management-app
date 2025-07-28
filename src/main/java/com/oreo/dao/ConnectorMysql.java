package com.oreo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorMysql {
    private Connection con = null;
    private final String url = "jdbc:mysql://localhost:3306/manage_users";
    private final String user = "root";
    private final String password = "root";

    public ConnectorMysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }
}
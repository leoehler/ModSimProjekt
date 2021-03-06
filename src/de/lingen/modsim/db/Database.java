package de.lingen.modsim.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private Connection conn;

    private Database() {
        String url= "jdbc:mariadb://localhost:3306/";
        String dbName = "ModSimProject";
        String driver = "org.mariadb.jdbc.Driver";
        String userName = "root";
        String password = "password";
        try {
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(url + dbName, userName, password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    private static class Inner {
        private static Database connection = new Database();
    }

    public static Database getInstance() {
        return Inner.connection;
    }

    public Connection getConn() {
        return conn;
    }

    public void insert() {

    }
}

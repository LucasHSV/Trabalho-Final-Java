package br.sapiens.configs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection conn = null;

    public SingletonConnection() throws SQLException {
        String jdbcURL = "jdbc:h2:mem:test";
        if(conn == null){
            conn = DriverManager.getConnection(jdbcURL);
            System.out.println("Connection being established");
        }
    }
    public Connection getConn() {
        return conn;
    }
}

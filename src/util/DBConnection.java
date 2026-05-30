package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection instance = null;
    private DBConnection(){}


    private static final String url = "jdbc:mysql://localhost:3306/studentdb";
    private static final String user = "root";
    private static final String password = System.getenv("DB_PASSWORD");


    public static Connection getConnection() throws SQLException {
        if (instance == null || instance.isClosed()) {
            instance = DriverManager.getConnection(url, user, password);
            return instance;
        }
        return instance;
    }
}

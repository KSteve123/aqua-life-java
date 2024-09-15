package com.Aqualife.Aqualife.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    // Single instance of DbConnection
    private static Connection con;

    // Private constructor to prevent instantiation
    private DbConnection() { }

    // Method to get the single instance of the connection
    public static Connection getConnection() throws Exception {
        if (con == null || con.isClosed()) {
            synchronized (DbConnection.class) {
                if (con == null || con.isClosed()) {
                    String dbRoot = "jdbc:mysql://";
                    String hostName = "localhost:3306/";
                    String dbName = "aqua_life";
                    String dbUrl = dbRoot + hostName + dbName;

                    String hostUsername = "root";
                    String hostPassword = "";
                    
                    // Load the MySQL driver
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    // Create the connection
                    con = DriverManager.getConnection(dbUrl, hostUsername, hostPassword);
                }
            }
        }
        return con;
    }
}

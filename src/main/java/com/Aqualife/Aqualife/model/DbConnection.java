
package com.Aqualife.Aqualife.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection getConnection() throws Exception{

        String dbRoot ="jdbc:mysql://";
        String hostName ="localhost:3306/";
        String dbName = "aqua_life";
        String dbUrl = dbRoot+hostName+dbName;

        String hostUsername = "root";
        String hostPassword = "";
        // connection with sql database
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(dbUrl, hostUsername, hostPassword);

        return con;
    }
}

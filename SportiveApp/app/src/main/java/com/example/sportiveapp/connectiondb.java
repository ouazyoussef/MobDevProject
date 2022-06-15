package com.example.sportiveapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectiondb {

    private static String ip = "127.0.0.1";// this is the host ip that your data base exists on you can use 10.0.2.2 for local host                                                    found on your pc. use if config for windows to find the ip if the database exists on                                                    your pc
    private static String port = "3306";// the port sql server runs on
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";// the driver that is required for this connection use                                                                           "org.postgresql.Driver" for connecting to postgresql
    private static String database = "CustomerCareSystem";// the data base name
    private static String username = "root";// the user name
    private static String password = "root";// the password
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database; // the connection url string

    public void connect(Connection connection) throws SQLException {
        connection = DriverManager.getConnection(url, username,password);
    }
}

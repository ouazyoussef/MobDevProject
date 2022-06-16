package com.example.sportiveapp;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBManagement {

    public DBManagement() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/androidprj", "root", "");

            String sql = "SELECT * FROM MyTable";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String first = resultSet.getString("username");
                String second = resultSet.getString("email");

                Log.d("First: ",first);
                Log.d("Second: ",second);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        DBManagement db = new DBManagement();
    }
}

package com.example.sportiveapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

public class DBManagement extends AsyncTask<String, Void, String> {
    Connection connection;
    public boolean UserIsReal(String Usr, String Pwd){
        final boolean[] isConnected = {false};

         new Thread(new Runnable() {
            @Override
            public void run(){
                String requete = "SELECT * FROM users where username = '" + Usr + "' and pwd = '" + Pwd + "';";

                PreparedStatement statement = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    statement = connection.prepareStatement(requete);
                    System.out.println("result rq");
                    ResultSet result = statement.executeQuery();
                    System.out.println("rsmd rq");
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    ArrayList<String> arrayResult = new ArrayList<>(columnCount);
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {
                            System.out.println("Connexion" + result.getString(i));
                            arrayResult.add(result.getString(i++));

                        }
                    }
                    if (!arrayResult.isEmpty())
                        isConnected[0] = true;
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }




            }

        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isConnected[0];
    }

    public DBManagement() {

    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    public DBManagement(String Query) {

    }
    public void fff() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    // ResultSet result = myDB.yourSelectQuery();
                    String sql = "SELECT * FROM users";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();
                    //Stores properties of a ResultSet object, including column count
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    ArrayList<String> arrayResult = new ArrayList<>(columnCount);
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {
                            System.out.println(result.getString(i));
                            arrayResult.add(result.getString(i++));

                        }
                    }
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }}).start();

    }
    public void fff2(String Query) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    // ResultSet result = myDB.yourSelectQuery();
                    String sql = Query;
                    PreparedStatement statement = connection.prepareStatement(sql);
                    ResultSet result = statement.executeQuery();
                    //Stores properties of a ResultSet object, including column count
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    ArrayList<String>  arrayResult = new ArrayList<>(columnCount);
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {
                            System.out.println(result.getString(i));
                            arrayResult.add(result.getString(i++));

                        }
                    }

                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }}).start();

    }
}

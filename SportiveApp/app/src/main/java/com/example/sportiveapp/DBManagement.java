package com.example.sportiveapp;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DBManagement extends AsyncTask<String, Void, String>
{
    Connection connection;
    String chain = "";
    int playedMatch = 0;
    int WinnedMatch = 0;

    public void CreateMatch(String Usr, String dat){
        String requete = "Insert into matchs values(MD5(RAND())," + "'"+Usr + "'"+ ","+ "'" +dat + "'"+ ", 2);";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(requete);
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
    public int getMatchWon (String user){
        String requete = "Select count(*) from matchs where username = " + "'"+ user + "'" + "and wol = '1'";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    PreparedStatement statement = connection.prepareStatement(requete);
                    System.out.println("result rq");
                    ResultSet result = statement.executeQuery();
                    System.out.println("rsmd rq");
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {
                            WinnedMatch = result.getInt(i++);
                        }
                    }
                    System.out.println("Close connection WinnedMatch " + WinnedMatch);
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }




            }

        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print WinnedMatch before return " + WinnedMatch);
        return WinnedMatch;
    }

    public int getMatchPlayed (String user){
        String requete = "Select count(*) from matchs where username = " + "'"+ user + "'";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    PreparedStatement statement = connection.prepareStatement(requete);
                    System.out.println("result rq");
                    ResultSet result = statement.executeQuery();
                    System.out.println("rsmd rq");
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {
                            playedMatch = result.getInt(i++);
                        }
                    }
                    System.out.println("Close connection playedMatch " + playedMatch);
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print playedMatch before return " + playedMatch);
        return playedMatch;
    }
    public String getHistory(String user){
        String requete = "Select * from matchs where username =" + "'"+ user + "'";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    PreparedStatement statement = connection.prepareStatement(requete);
                    System.out.println("result rq");
                    ResultSet result = statement.executeQuery();
                    System.out.println("rsmd rq");
                    ResultSetMetaData rsmd = result.getMetaData();
                    int columnCount = rsmd.getColumnCount();

                    //ArrayList<String> arrayResult = new ArrayList<>(columnCount);
                    while (result.next()) {
                        int i = 1;
                        while (i <= columnCount) {

                            chain = chain + result.getString(i++) + "-";
                            System.out.println(chain);

                        }
                        chain = chain + "|";

                        System.out.println("Sortie du while column");
                    }
                    System.out.println("Close connection chain " + chain);
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }




            }

        }).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print chain before return " + chain);
        return chain;
    }
    public void CreateUser(String Usr, String Pwd, String Mail, String DateNaissance, String Bio){
        String requete = "INSERT INTO users VALUES " + "('" + Usr + "'," + "'" + Mail + "'," + "'" + Pwd + "'," + "'" + Bio + "','"  + DateNaissance + "')";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://10.0.2.2:3306/androidprj", "root", "");
                    System.out.println("Statement + " + requete);
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(requete);
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
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

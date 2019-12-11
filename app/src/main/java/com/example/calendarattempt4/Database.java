package com.example.calendarattempt4;

import java.sql.*;

public class Database {
    protected static String dbUrl = "jdbc:postgresql://ec2-46-137-120-243.eu-west-1.compute.amazonaws.com:5432/daku93qk12ot3o?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory&user=ejzndyzesfoyqk&password=e16216b71f70ac9b098db783817afd90c45b71a0b4c117590985968f9ea31bb8";
    protected Connection conn;
    protected Statement s;

    public boolean connect()  {
        try {
            // Registers the drive
            Class.forName("org.postgresql.Driver");
            Connection conn= DriverManager.getConnection(dbUrl);
            this.s=conn.createStatement();
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not find the database driver ");
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not connect to the database");
            return false;
        }
    }

    public Statement getConnection() {
        return this.s;
    }
}
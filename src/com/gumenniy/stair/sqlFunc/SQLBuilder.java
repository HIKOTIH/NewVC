package com.gumenniy.stair.sqlFunc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLBuilder {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./dbstair01";


    private static final String USER = "us";
    private static final String PASS = "1234";


    public static void buildDB () {
        sqlBuildClient ();
        sqlBuildOrder ();
    }


    private static void sqlBuildClient () {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName (JDBC_DRIVER);
            conn = DriverManager.getConnection (DB_URL, USER, PASS);
            stmt = conn.createStatement ();
            String sqlClientBuild = "CREATE TABLE   CLIENTS" +
                    "  (" +
                    "idClient INTEGER AUTO_INCREMENT, " +
                    " name VARCHAR(255) not null , " +
                    " phone VARCHAR(255) not null , " +
                    " delivery VARCHAR(255), " +
                    " PRIMARY KEY ( idClient )" +
                    ")";
            stmt.executeUpdate (sqlClientBuild);
            stmt.close ();
            conn.close ();
        } catch (SQLException se) {
            se.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            try {
                if (stmt != null) stmt.close ();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close ();
            } catch (SQLException se) {
                se.printStackTrace ();
            }
        }
    }

    private static void sqlBuildOrder () {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName (JDBC_DRIVER);
            conn = DriverManager.getConnection (DB_URL, USER, PASS);
            stmt = conn.createStatement ();
            String sqlOrderBuild = "CREATE TABLE ORDERS  " +
                    "(" +
                    "idOrder INTEGER AUTO_INCREMENT, " +
                    "Date DATE not null ," +
                    "boxSize VARCHAR (255) not null ," +
                    "idClient INTEGER  not null REFERENCES CLIENTS(idClient) ," +
                    "quantity VARCHAR (255) ," +
                    "price VARCHAR (255) ," +
                    "done BOOLEAN not null ," +
                    "compliteDate VARCHAR (255)," +
                    "note VARCHAR (255)," +
                    "PRIMARY KEY ( idOrder )," +
                    ") ";
            stmt.executeUpdate (sqlOrderBuild);
            stmt.close ();
            conn.close ();
        } catch (SQLException se) {
            se.printStackTrace ();
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            try {
                if (stmt != null) stmt.close ();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close ();
            } catch (SQLException se) {
                se.printStackTrace ();
            }
        }
    }
}






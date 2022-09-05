package com.gumenniy.stair.sqlFunc;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:./dbstair01";


    private static final String USER = "us";
    private static final String PASS = "1234";

    private static Connection conn = null;


    private static void dbConnect () throws SQLException, ClassNotFoundException {

        try {
            Class.forName (JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
            throw e;
        }
        try {
            conn = DriverManager.getConnection (DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace ();
            throw e;
        }
    }

    private static void dbDisconnect () {
        try {
            if (conn != null && !conn.isClosed ()) {
                conn.close ();
            }
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace ();
            }
        }
    }

    public static ResultSet dbExecuteQuery ( String queryStmt ) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs;
        try {
            dbConnect ();
            stmt = conn.createStatement ();
            resultSet = stmt.executeQuery (queryStmt);
            crs = new CachedRowSetImpl ();
            crs.populate (resultSet);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close ();
            }
            if (stmt != null) {
                stmt.close ();
            }
            dbDisconnect ();
        }
        return crs;
    }

    public static void dbExecuteUpdate ( String sqlStmt ) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        try {
            dbConnect ();
            stmt = conn.createStatement ();
            stmt.executeUpdate (sqlStmt);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close ();
            }
            dbDisconnect ();
        }
    }
}

package wolfPubDB.connect;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 * Plain Old Java Object (POJO) class for storing and passing results from
 * SQL query.
 */

public class DBConnect {
        /**
         * This function connects to the mariadb database with the
         *          provided jdbc url, username and password.
         * 
         * mariadb jdbc driver is used for getting the connection
         * 
         * 
         * @return returns a connection to mariadb database
         * @throws SQLException
         */
        public static Connection getConnection() throws SQLException
        {
            // System.out.println("Connection initiating ....");
            Connection conn = null;
            String jdbcUrl = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/kacrosby";
            String user = "kacrosby";
            String password = "hazel";
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conn = DriverManager.getConnection(jdbcUrl, user, password);
                // System.out.println("Connection initiated");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }
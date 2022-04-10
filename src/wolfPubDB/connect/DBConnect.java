package wolfPubDB.connect;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import static java.lang.Class.forName;

public class DBConnect {
        public static Connection getConnection() throws SQLException
        {
            System.out.println("Connection initiating ....");
            Connection conn = null;
            String jdbcUrl = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/kacrosby";
            String user = "kacrosby";
            String password = "hazel";
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conn = DriverManager.getConnection(jdbcUrl, user, password);
                System.out.println("Connection initiated");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return conn;
        }

    }
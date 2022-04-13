package wolfPubDB.transactions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import wolfPubDB.connect.DBConnect;
import wolfPubDB.taskAndOperations.*;

public class TransactionFunctions {
    public static boolean addPublication(String publicationId, String title, String periodicity, String topics, String isbn, Date publicationDate, String edition) throws SQLException {
        //Transaction
        boolean t1 = false;
        boolean t2 = false;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "insert into publication(publicationId, title, periodicity, topics) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setString(2, title);
            stat.setString(3, periodicity);
            stat.setString(4, topics);
            stat.executeUpdate();

            t1 = true;

            t2 = Book.addBook(conn, publicationId, isbn, publicationDate, edition);
            
            if(t1 && t2){
                conn.commit();
                System.out.println("Transaction successful");
                return true;
            }else{
                conn.rollback();
                System.out.println("Transaction Failed");
                return false;
            }
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println("Transaction Failed");
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
    public static boolean addPublication(String publicationId, String title, String periodicity, String topics, Date issueDate, String type) throws SQLException {
        //Transaction
        boolean t1 = false;
        boolean t2 = false;
        Connection conn = null;
        try {
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "insert into publication(publicationId, title, periodicity, topics) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setString(2, title);
            stat.setString(3, periodicity);
            stat.setString(4, topics);
            stat.executeUpdate();

            t1 = true;
            t2 = Issue.addIssue(conn, publicationId, issueDate, type);

            if(t1 && t2){
                conn.commit();
                System.out.println("Transaction successful");
                return true;
            }else{
                conn.rollback();
                System.out.println("Transaction Failed");
                return false;
            }
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println("Transaction Failed");
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
    public static boolean addAuthor(String staffId, String name, String type) throws SQLException{
        //Transaction
        Connection conn = DBConnect.getConnection();
        conn.setAutoCommit(false);
        boolean t1 = false;
        boolean t2 = false;
        try {
            String query = "insert into staff(staffId, name, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            t1 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            String query2 = "insert into author values (?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            t2 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (t1 && t2){
            conn.commit();
            System.out.println("Transaction Successful");
            conn.setAutoCommit(true);
            conn.close();
            return true;
        }
        else{
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.setAutoCommit(true);
            conn.close();
            return false;
        }
    }

    public static boolean addEditor(String staffId, String name, String type) throws SQLException {
        //Transaction
        Connection conn = DBConnect.getConnection();
        conn.setAutoCommit(false);
        boolean t1 = false;
        boolean t2 = false;
        try {
            String query = "insert into staff(staffId, name, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            t1 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            String query2 = "insert into editor values (?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            t2 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (t1 && t2){
            conn.commit();
            System.out.println("Transaction Successful");
            conn.setAutoCommit(true);
            conn.close();
            return true;
        }
        else{
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.setAutoCommit(true);
            conn.close();
            return false;
        }
    }

   
}

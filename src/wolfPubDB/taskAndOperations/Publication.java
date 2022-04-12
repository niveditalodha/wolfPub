package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.PublicationClass;
import wolfPubDB.connect.*;


public class Publication {

    public static ArrayList<PublicationClass> selectPublication() {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<PublicationClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from publication");
            while (res.next()) {
                PublicationClass pub = new PublicationClass(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<PublicationClass> selectPublication(String publicationId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from publication where publicationId = '" +  publicationId+"'");
            ArrayList<PublicationClass> output = new ArrayList<>();
            while (res.next()) {
                PublicationClass pub = new PublicationClass(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Boolean addPublication(String publicationId, String title, String periodicity, String topics) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into publication(publicationId, title, periodicity, topics) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setString(2, title);
            stat.setString(3, periodicity);
            stat.setString(4, topics);
            stat.executeUpdate();
            conn.commit();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addPublication(String publicationId, String title, String periodicity, String topics, String isbn, Date publicationDate, String edition) throws SQLException {
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
            conn.commit();
            t2 = Book.addBook(publicationId, isbn, publicationDate, edition);
            
            if(t2){
                System.out.println("Transaction successful");
                return true;
            }else{
                System.out.println("Transaction Failed");
                return false;
            }
        } catch (SQLException ex) {
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }
    

    public static boolean addPublication(String publicationId, String title, String periodicity, String topics, Date issueDate, String type) throws SQLException {
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
            conn.commit();
            t2 = Issue.addIssue(publicationId, issueDate, type);

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
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }

    public static boolean addPublicationBook(String publicationId, String isbn, Date publicationDate, String edition, String title, String periodicity, String topics, Date issueDate, String type) throws SQLException {
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
            conn.commit();
            t2 = Issue.addIssue(publicationId, issueDate, type);

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
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        try{
                conn = DBConnect.getConnection();
                conn.setAutoCommit(false);
                String query = "INSERT INTO book(publicationId, isbn, publicationDate, edition) VALUES(?,?,?,?)";
                PreparedStatement stat = conn.prepareStatement(query);
                stat.setString(1, publicationId);
                stat.setString(2, isbn);
                stat.setDate(3, publicationDate);
                stat.setString(4, edition);
                stat.executeUpdate();
    
                t1 = true;
    
                if (t1){
                    conn.commit();
                    System.out.println("Transaction Successful");
                    // conn.close();
                    return true;
                }
                else{
                    conn.rollback();
                    System.out.println("Transaction Failed");
                    // conn.close();
                    return false;
                }
            }
            catch (SQLException ex) {
                conn.rollback();
                System.out.println("Transaction Failed");
                conn.close();
                return false;
            } finally {
                if(conn != null){
                    conn.setAutoCommit(true);
                    conn.close();
                }
        }
        }
    }

    public static Boolean updatePublication(String publicationId, String title, String periodicity, String topics) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update publication set title=?, periodicity=?, topics=? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, title);
            stat.setString(2, periodicity);
            stat.setString(3, topics);
            stat.setString(4, publicationId);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from publication where publicationId='"+publicationId+"'");
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");

            }

            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deletePublication(String publicationId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM publication WHERE publicationId= '" + publicationId+"'");
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
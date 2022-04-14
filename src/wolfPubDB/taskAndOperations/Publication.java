package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.classes.PublicationClass;
import wolfPubDB.connect.*;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the Publication.
 */

public class Publication {

    /**
     * Method for viewing data in the payment table.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static ArrayList<PublicationClass> selectPublication() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            ArrayList<PublicationClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from publication");
            while (res.next()) {
                PublicationClass pub = new PublicationClass(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\ttitle\t\t\tperiodicity\ttopics");
            return output;
        } catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            return null;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            return null;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }finally{
                conn.close();
        }
    }

    /**
     * Method for viewing data in the payment table based on PublicationId.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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

    /**
     * Method for inserting data in the publication table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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

    /**
     * Method for inserting data in the publication and books table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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
        }catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            conn.rollback();
            System.out.println("Transaction Failed");
            return false;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            conn.rollback();
            System.out.println("Transaction Failed");
            return false;
        }catch (SQLException ex) {
            ex.printStackTrace();
            conn.rollback();
            System.out.println("Transaction Failed");
            return false;
        }finally{
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        } 
    }
    
    /**
     * Method for inserting data in the publication and issue table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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
        }catch(SQLIntegrityConstraintViolationException ex){
                System.out.println("Foreign key constrain violated!!!");
                
                conn.rollback();
                System.out.println("Transaction Failed");
                return false;
            } catch(SQLSyntaxErrorException ex){
                System.out.println("Invalid SQL syntax!!!");
                conn.rollback();
                System.out.println("Transaction Failed");
                return false;
            }catch (SQLException ex) {
                ex.printStackTrace();
                conn.rollback();
                System.out.println("Transaction Failed!!");
                return false;
            }finally{
                if(conn != null){
                    conn.setAutoCommit(true);
                    conn.close();
                }
        }
    }

    /**
     * Method for updating data in the publication table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select count(*) as total from publication where publicationId='"+publicationId+"'");
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

    /**
     * Method for deleting data in the publication table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
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
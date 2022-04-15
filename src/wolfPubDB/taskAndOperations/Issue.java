package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.IssueClass;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the Issue.
 */

public class Issue {

    /**
     * Method for viewing data in the Issue table.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static ArrayList<IssueClass> selectIssue() throws SQLException {
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from issue");
            ArrayList<IssueClass> output = new ArrayList<>();
            while (res.next()) {
                IssueClass p = new IssueClass(res.getString("publicationId"), res.getDate("issueDate"), res.getString("type"));
                output.add(p);
            }
            conn.close();
            System.out.println("publicationId\tissueDate\ttype");
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
     * Method for viewing data in the Issue table based on publicationId.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static ArrayList<IssueClass> selectIssue(String publicationId) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from issue where publicationId = '" +  publicationId+"'");
            ArrayList<IssueClass> output = new ArrayList<>();
            while (res.next()) {
                IssueClass p = new IssueClass(res.getString("publicationId"), res.getDate("issueDate"), res.getString("type"));
                output.add(p);
            }
            conn.close();
            System.out.println("publicationId\tissueDate\ttype");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Method for inserting data in the Issue table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean addIssue(Connection conn, String publicationId, Date issueDate, String type) throws SQLException{
        try {
            String query = "insert into issue(publicationId, issueDate, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setDate(2, issueDate);
            stat.setString(3, type);
            stat.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Method for updating data in the Issue table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean updateIssue(String publicationId, Date issueDate, String type) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            String query = "Update issue set issueDate = ?, type = ? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setDate(1, issueDate);
            stat.setString(2, type);
            stat.setString(3, publicationId);
            stat.executeUpdate();
            conn.close();
            return true;
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
     * Method for deleting data in the Issue table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean deleteIssue(String publicationId) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM issue WHERE publicationId= '" + publicationId+"'");
            conn.close();
            return true;
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

}
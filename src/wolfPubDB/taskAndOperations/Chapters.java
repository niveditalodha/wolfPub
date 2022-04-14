package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.classes.ChaptersClass;
import wolfPubDB.connect.*;


/**
 * Plain Old Java Object (POJO) class for storing and passing results from
 * SQL query.
 */
public class Chapters{

    /**
     * Method for viewing the Chapter table from the database.
     * Connects to the DB, Creates an SQL query string and returns the results as an ArrayList.
     *
     * @return Returns the ArrayList output of select chapter table contents
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ArrayList<ChaptersClass> selectChapter() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {   
            ArrayList<ChaptersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from chapters");
            while (res.next()) {
                ChaptersClass chp = new ChaptersClass(res.getString("publicationId"), res.getString("chapterNumber"), res.getString("chapterTitle"));
                output.add(chp);
            }
            conn.close();
            System.out.println("publicationId\tchapterNumber\tchapterTitle");
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
     * Method for viewing the Chapter table from the database.
     * Connects to the DB, Creates an SQL query string and returns the results as an ArrayList.
     *
     * @return Returns the ArrayList output of select chapter table contents
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ArrayList<ChaptersClass> selectChapter(String publicationId, String chapterNumber) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<ChaptersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from chapters where publicationId='"+publicationId+"' and chapterNumber='"+chapterNumber+"'");
            while (res.next()) {
                ChaptersClass chp = new ChaptersClass(res.getString("publicationId"), res.getString("chapterNumber"), res.getString("chapterTitle"));
                output.add(chp);
            }
            conn.close();
            System.out.println("publicationId\tchapterNumber\tchapterTitle");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Method for adding the chapters row in the chapters table from the database.
     * Connects to the DB, Creates an SQL query string and returns the success or failure.
     *
     * @return Returns the boolean true is success else boolean false
     * @throws SQLException For handling any DB related runtime exceptions.
     */

    public static boolean addChapter(String publicationId, String chapterNumber, String chapterTitle) throws SQLException{
        Connection conn = null;
        boolean t1 = false;
        try{
            conn = DBConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "INSERT INTO chapters(publicationId, chapterNumber, chapterTitle) VALUES(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setString(2, chapterNumber);
            stat.setString(3, chapterTitle);
            stat.executeUpdate();

            t1 = true;

            if (t1){
                conn.commit();
                System.out.println("Transaction Successful");
                return true;
            }
            else{
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
            if(conn!=null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    
}


    /**
     * Method for updating the chapters row in the chapters table from the database.
     * Connects to the DB, Creates an SQL query string and returns the success or failure.
     *
     * @return Returns the boolean true is success else boolean false
     * @throws SQLException For handling any DB related runtime exceptions.
     */

    public static Boolean updateChaptersTitle(String publicationId, String chapterNumber, String chapterTitle) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try{
            String query = "Update chapters set chapterTitle = ? where publicationId =? and chapterNumber=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, chapterTitle);
            stat.setString(2, publicationId);
            stat.setString(3, chapterNumber);
            stat.executeUpdate();
            
            conn.close();
            return true;
        }catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            return false;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            return false;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
                conn.close();
        }
    }

    
    /**
     * Method for deleting the chapters row from the chapters table from the database.
     * Connects to the DB, Creates an SQL query string and returns the success or failure.
     *
     * @return Returns the boolean true is success else boolean false
     * @throws SQLException For handling any DB related runtime exceptions.
     */

    public static Boolean deleteChapter(String publicationId, String chapterNumber) throws SQLException {
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM chapters WHERE publicationId= '"+publicationId+"' and chapterNumber='"+chapterNumber+"'");
            conn.close();
            return true;
        } catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            return false;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            return false;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
                conn.close();
        }
    }
}
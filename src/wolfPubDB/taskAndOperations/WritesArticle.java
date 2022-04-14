package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.WritesArticleClass;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the articles author.
 */

public class WritesArticle{

    /**
     * Method for viewing the WritesArticle table.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static ArrayList<WritesArticleClass> selectWritesArticle() throws SQLException {
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from writesarticle");
            ArrayList<WritesArticleClass> output = new ArrayList<>();
            while (res.next()) {
                WritesArticleClass row = new WritesArticleClass(res.getString("staffId"), res.getString("articleId"));
                output.add(row);
            }
            conn.close();
            System.out.println("staffId\t\tarticleId");
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
     * Method for updating data(Author, article) into the WritesArticle table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static boolean updateWritesArticleAuthor(String articleId, String staffId) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try {
            String query = "Update writesarticle set staffId = ? where articleId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, articleId);
            stat.executeUpdate();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("Select count(*) as total from writesarticle where articleId='"+articleId+"'");
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close();
            return false;
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

    /**
     * Method for inserting data(Author, article) into the WritesArticle table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static boolean addWritesArticle(String staffId, String articleId) throws SQLException {
        Connection conn = DBConnect.getConnection();
        try {
            String query = "insert into writesarticle(staffId, articleId) values (?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, articleId);
            stat.executeUpdate();
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
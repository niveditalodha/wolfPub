package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.WritesBookClass;
import wolfPubDB.connect.*;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the books author.
 */

public class WritesBook {

    /**
     * Method for viewing the WritesBook table from the database.
     * Connects to the DB, Creates an SQL query string and returns the results as an ArrayList.
     *
     * @return Returns the ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ArrayList<WritesBookClass> selectWritesBook() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from writesbook");
            ArrayList<WritesBookClass> output = new ArrayList<>();
            while (res.next()) {
                WritesBookClass row = new WritesBookClass(res.getString("staffId"), res.getString("publicationId"));
                output.add(row);
            }
            conn.close();
            System.out.println("staffId\t\tpublicationId");
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
     * Method for inserting data(Author, publication) into the WritesBook table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */

    public static boolean addWritesBook(String staffId, String publicationId) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            String query = "insert into writesbook(staffId, publicationId) values (?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, publicationId);
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

    /**
     * Method for updating data(Author, publication) into the WritesBook table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */

    public static Boolean updateWritesBookChapterAuthor(String publicationId, String staffId) throws SQLException{
        int count = 0;
        Connection conn = DBConnect.getConnection();
        try{
            String query = "Update writesbook set staffId = ? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, publicationId);
            stat.executeUpdate();
            
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select count(*) as total from writesbook where publicationId='"+publicationId+"'");
            while (res.next()) {
                count = res.getInt("total");
            }
            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close();
            return false;
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

}
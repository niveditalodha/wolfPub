package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.Book;
import wolfPub.connect.*;

public class Book{

    public static ArrayList<Book> selectBook() throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Book> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book");
            while (res.next()) {
                Book pub = new Book(res.getString("publicationId"), res.getString("isbn"), res.getString("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Book> selectBook(String publicationId) throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Book> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book where publication="+publicationId);
            while (res.next()) {
                Book pub = new Book(res.getString("publicationId"), res.getString("isbn"), res.getString("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addBook(String publicationId, String isbn, Date publicationDate, String edition) throws SQLException{
        Connection conn = null;
        boolean t1 = false;
        try{
            conn = DbConnect.getConnection();
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
                conn.close();
                return true;
            }
            else{
                conn.rollback();
                System.out.println("Transaction Failed");
                conn.close();
                return false;
            }
        }
        catch (SQLException ex) {
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.close()
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close()
            }
    }
}


    public static Boolean updateBook(String publicationId, String isbn, Date publicationDate, String edition) throws SQLException{
        int count = 0;
        try{
            Connection conn = DbConnect.getConnection();
            String query = "Update book set isbn=?, publicationDate=?, edition=? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, isbn);
            stat.setDate(2, publicationDate);
            stat.setString(3, edition);
            stat.setString(4,publicationId);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from book where publicationId="+publicationId);
            while (res.next()) {
                count = res.getInt("total");
            }
            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close()
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deletePublication(String publicationId) throws SQLException {
        try {
            Connection conn = DbConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM book WHERE publicationId= " + publicationId);
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.BookClass;
import wolfPubDB.connect.*;

public class Book{

    public static ArrayList<BookClass> selectBook() throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<BookClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book");
            while (res.next()) {
                BookClass pub = new BookClass(res.getString("publicationId"), res.getString("isbn"), res.getDate("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\tisbn\tpublicationDate\tedition");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<BookClass> selectBook(String publicationId) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<BookClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book where publicationId='"+publicationId+"'");
            while (res.next()) {
                BookClass pub = new BookClass(res.getString("publicationId"), res.getString("isbn"), res.getDate("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\tisbn\tpublicationDate\tedition");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<BookClass> selectBookByTopic(String topics) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<BookClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            String query = "select * from book where publicationId in (select publicationId from publication where topics = '"+topics+"')";
            ResultSet res = stat.executeQuery(query);
            while (res.next()) {
                BookClass pub = new BookClass(res.getString("publicationId"), res.getString("isbn"), res.getDate("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\tisbn\tpublicationDate\tedition");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<BookClass> selectBookByDate(Date publicationDate) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<BookClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book where publicationDate='"+publicationDate+"'");
            while (res.next()) {
                BookClass pub = new BookClass(res.getString("publicationId"), res.getString("isbn"), res.getDate("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\tisbn\tpublicationDate\tedition");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<BookClass> selectBookByAuthor(String name) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<BookClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from book where publicationId in (select publicationId from writesbook where staffId in (select staffId from staff where name = '"+name+"'))");
            while (res.next()) {
                BookClass pub = new BookClass(res.getString("publicationId"), res.getString("isbn"), res.getDate("publicationDate"), res.getString("edition"));
                output.add(pub);
            }
            conn.close();
            System.out.println("publicationId\tisbn\tpublicationDate\tedition");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    


    public static boolean addBook(Connection conn, String publicationId, String isbn, Date publicationDate, String edition) throws SQLException{
        try{
            String query = "INSERT INTO book(publicationId, isbn, publicationDate, edition) VALUES(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publicationId);
            stat.setString(2, isbn);
            stat.setDate(3, publicationDate);
            stat.setString(4, edition);
            stat.executeUpdate();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Transaction Failed");
            return false;
        }
}


    public static Boolean updateBook(String publicationId, String isbn, Date publicationDate, String edition) throws SQLException{
        int count = 0;
        try{
            Connection conn = DBConnect.getConnection();
            String query = "Update book set isbn=?, publicationDate=?, edition=? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, isbn);
            stat.setDate(2, publicationDate);
            stat.setString(3, edition);
            stat.setString(4,publicationId);
            stat.executeUpdate();
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select count(*) as total from book where publicationId='"+publicationId+"'");
            while (res.next()) {
                count = res.getInt("total");
            }
            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteBook(String publicationId) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM book WHERE publicationId= '" + publicationId+"'");
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
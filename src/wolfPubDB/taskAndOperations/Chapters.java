package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.Chapters;
import wolfPub.connect.*;

public class chapters{

    public static ArrayList<Chapters> selectBook() throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Chapters> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from chapters");
            while (res.next()) {
                Chapters chp = new Chapters(res.getString("publicationId"), res.getString("chapterNumber"), res.getString("chapterTitle"));
                output.add(chp);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Chapters> selectChapter(String publicationId, String chapterNumber) throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Chapters> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from chapters where publicationId="+publicationId+" and chapterNumber="+chapterNumber);
            while (res.next()) {
                Chapters chp = new Chapters(res.getString("publicationId"), res.getString("chapterNumber"), res.getString("chapterTitle"));
                output.add(chp);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addChapter(String publicationId, String chapterNumber, String chapterTitle) throws SQLException{
        Connection conn = null;
        boolean t1 = false;
        try{
            conn = DbConnect.getConnection();
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
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
    }
}


    public static Boolean updateChaptersTitle(String publicationId, String chapterNumber, String chapterTitle) throws SQLException{
        int count = 0;
        try{
            Connection conn = DbConnect.getConnection();
            String query = "Update chapters set chapterTitle = ? where publicationId =? and chapterNumber=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, chapterTitle);
            stat.setString(2, publicationId);
            stat.setString(2, chapterNumber);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from chapters where publicationId="+publicationId+" and chapterNumber="+chapterNumber);
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

    


    public static Boolean deleteChapter(String publicationId, String chapterNumber) throws SQLException {
        try {
            Connection conn = DbConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM chapters WHERE publicationId= "+publicationId+" and chapterNumber="+chapterNumber);
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.Publication;
import wolfPub.connect.*;


public class Publication {

    public static ArrayList<Publication> selectPublication() {
        try {
            Connection conn = DbConnect.getConnection();
            ArrayList<Publication> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from publication");
            while (res.next()) {
                Publication pub = new Publication(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(pub);
            }
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Publication> selectPublication(String publicationId) {
        try {
            Connection conn = DbConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from publication where publicationId = " +  publicationId);
            ArrayList<Publication> output = new ArrayList<>();
            while (res.next()) {
                Publication pub = new Publication(res.getInt("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(pub);
            }
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


//Start Transaction
    public static boolean addPublication(String publicationId, String title, String periodicity, String topics, String isbn, String edition, Date publicationDate) throws SQLException {
        boolean trans1 = false;
        boolean trans2 = false;
        Connection conn = null;
        try {
            conn = DbConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "insert into publication(publicationId, title, periodicity, topics) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, publicationId);
            stat.setString(2, title);
            stat.setString(3, periodicity);
            stat.setString(4, topics);
            stat.executeUpdate();

            trans1 = true;
            trans2 = Book.addBook(conn, PID, PublicationDate, ISBN, Edition);

            if(trans1 && trans2){
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
            }
        }
    }

    public static Boolean addPublication(Integer PID, String topic, String title, String pub_no) {
        try {
            Connection conn = DbConnect.getConnection();
            String query = "insert into PUBLICATION(PID, TOPIC, TITLE, PUB_NO) values (?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, publication);
            stat.setString(2, topic);
            stat.setString(3, periodicity);
            stat.setString(4, topics);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("select publicationId from publication");
            int p_id = 0;
            while (res.next())
                publicationId = res.getInt("publicationId");
            conn.commit();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public static Boolean updatePublication(Integer PID, String topic, String title, String pub_no) {
        try {
            Connection conn = DbConnect.getConnection();
            String query = "Update PUBLICATION set TOPIC=?, TITLE=?, PUB_NO=? where PID =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, topic);
            stat.setString(2, title);
            stat.setString(3, pub_no);
            stat.setInt(4,PID);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("Select count(*) as count_val from PUBLICATION where PID="+PID);
            int count = 0;
            while (res.next()) {
                count = res.getInt("count_val");

            }

            if (count!=0){
                return  true;
            }
            return false;
            //return Boolean.valueOf(true);
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deletePublication(Integer PID) {
        try {
            Connection conn = DbConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM PUBLICATION WHERE PID= " + PID);
            return Boolean.valueOf(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

}
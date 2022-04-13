package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.WritesArticleClass;

public class WritesArticle{

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
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }


    public static boolean updateWritesArticleAuthor(String articleId, String staffId) throws SQLException{
        try {
            Connection conn = DBConnect.getConnection();
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
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static boolean addWritesArticle(String staffId, String articleId) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into writesarticle(staffId, articleId) values (?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, articleId);
            stat.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
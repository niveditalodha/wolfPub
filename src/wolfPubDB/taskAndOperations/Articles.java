package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.Articles;

public class Articles{

    public static ArrayList<Articles> selectArticles() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from articles");
            ArrayList<Articles> output = new ArrayList<>();
            while (res.next()) {
                Articles a = new Articles(res.getString("articleId"), res.getString("title"), Date.valueOf(res.getDate("creationDate")), res.getString("text"), res.getString("publicationId"));
                output.add(a);
            }
            conn.close()
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean addArticle(String articleId, String title ,Date creationDate, String text, String publicationId) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into issue(articleId, title, creationDate, text, publicationId) values (?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, articleId);
            stat.setString(2, title);
            stat.setDate(3, creationDate);
            stat.setString(4, text);
            stat.setString(5, publicationId);
            stat.executeUpdate();
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean updateArticle(String articleId, String title ,Date creationDate, String text, String publicationId) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update articles set title = ?, creationDate = ?, text = ?, publicationId = ? where articleId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, title);
            stat.setDate(2, creationDate);
            stat.setString(3, text);
            stat.setString(4,publicationId);
            stat.setString(5, articleId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from articles where articleId="+articleId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                conn.close()
                return  true;
            }
            conn.close()
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    public static Boolean deleteArticle(String articleId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM articles WHERE articleId= " + articleId);
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}
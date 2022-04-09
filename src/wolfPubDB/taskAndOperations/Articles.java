package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.ArticlesClass;

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
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Articles> selectArticlesByTopic(String topics) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from articles where publicationId in (select publicationId from publication where topics = "+topics+")");
            ArrayList<Articles> output = new ArrayList<>();
            while (res.next()) {
                Articles a = new Articles(res.getString("articleId"), res.getString("title"), Date.valueOf(res.getDate("creationDate")), res.getString("text"), res.getString("publicationId"));
                output.add(a);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Articles> selectArticlesByAuthor(String staffId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from articles where articleId in (select articleId from writesarticle where staffId = "+staffId+")");
            ArrayList<Articles> output = new ArrayList<>();
            while (res.next()) {
                Articles a = new Articles(res.getString("articleId"), res.getString("title"), Date.valueOf(res.getDate("creationDate")), res.getString("text"), res.getString("publicationId"));
                output.add(a);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Articles> selectArticlesByDate(String creationDate) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from articles where creationDate = "+creationDate);
            ArrayList<Articles> output = new ArrayList<>();
            while (res.next()) {
                Articles a = new Articles(res.getString("articleId"), res.getString("title"), Date.valueOf(res.getDate("creationDate")), res.getString("text"), res.getString("publicationId"));
                output.add(a);
            }
            conn.close();
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
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean updateArticleTitle(String articleId, String title) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update articles set title = ? where articleId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, title);
            stat.setString(2, articleId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from articles where articleId="+articleId);
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

    public static Boolean updateArticleCreationDate(String articleId, Date creationDate) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update articles set creationDate = ? where articleId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setDate(1, creationDate);
            stat.setString(2, articleId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from articles where articleId="+articleId);
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

    public static Boolean updateArticleText(String articleId, String text) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update articles set text = ? where articleId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, text);
            stat.setString(2, articleId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from articles where articleId="+articleId);
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

    public static Boolean updateArticlesTopic(String articleId, String topics) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update publication set topics = ? where publicationId = (select publicationId from articles where articleId=?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, topics);
            stat.setString(2, articleId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from publication where publicationId=(select publicationId from articles where articleId="+articleId+")";
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

    public static Boolean deleteArticle(String articleId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM articles WHERE articleId= " + articleId);
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}
package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.WritesArticle;

public class WritesArticle{

    public static ArrayList<WritesArticle> selectWritesArticle() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from writesarticle");
            ArrayList<WritesArticle> output = new ArrayList<>();
            while (res.next()) {
                WritesArticle row = new WritesArticle(res.getString("staffId"), res.getString("articleId"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean addWritesArticle(String staffId, String articleId) {
        boolean state = false;
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into writesarticle(staffId, articlesId) values (?,?)";
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
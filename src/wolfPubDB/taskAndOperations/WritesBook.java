package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.WritesBookClass;
import wolfPubDB.connect.*;



public class WritesBook {
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
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }



    public static boolean addWritesBook(String staffId, String publicationId) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            String query = "insert into writesBook(staffId, publicationId) values (?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, publicationId);
            stat.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            conn.close();
        }
    }

    public static Boolean updateWritesBookChapterAuthor(String publicationId, String staffId) throws SQLException{
        int count = 0;
        Connection conn = DBConnect.getConnection();
        try{
            String query = "Update writesbook set staffId = ? where publicationId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, publicationId);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from writesbook where publicationId='"+publicationId+"'");
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
        finally{
            conn.close();
        }
    }

}
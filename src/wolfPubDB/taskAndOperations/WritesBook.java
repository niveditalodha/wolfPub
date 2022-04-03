package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.WritesBook;
import wolfPubDB.connect.*;



public class WritesBook {
    public static ArrayList<WritesBook> selectEdits() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from writesbook");
            ArrayList<WritesBook> output = new ArrayList<>();
            while (res.next()) {
                WritesBook row = new WritesBook(res.getString("staffId"), res.getString("publicationId"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean addWritesBook(String staffId, String publicationId) {
        boolean state = false;
        try {
            Connection conn = DBConnect.getConnection();
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
    }

}
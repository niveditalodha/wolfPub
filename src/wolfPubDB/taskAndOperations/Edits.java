package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.EditsClass;
import wolfPubDB.connect.*;



public class Edits {
    public static ArrayList<Edits> selectEdits() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from edits");
            ArrayList<Edits> output = new ArrayList<>();
            while (res.next()) {
                Edits row = new Edits(res.getString("staffId"), res.getString("publicationId"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean addEdits(String staffId, String publicationId) {
        boolean state = false;
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into edits(staffId, publicationId) values (?,?)";
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


    public static  ArrayList<Edits> selectEditorPublication(String staffId){
        try{

            Connection conn = DbConnection.getConnection();
            ArrayList<Edits> output = new ArrayList<>();
            String query = "Select * from publication where publicationId IN (Select publicationId from edits where staffId=" + staffId +")";
            Statement stat = conn.createStatement();
            ResultSet res =  st.executeQuery(query);

            while(res.next()){
                Edits row = new Edits(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
                output.add(row);
            }
            conn.close();
            return output;



        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
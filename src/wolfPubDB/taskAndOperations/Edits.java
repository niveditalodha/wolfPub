package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.EditsClass;
import wolfPubDB.classes.PublicationClass;
import wolfPubDB.connect.*;



public class Edits {
    public static ArrayList<EditsClass> selectEdits() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from edits");
            ArrayList<EditsClass> output = new ArrayList<>();
            while (res.next()) {
                EditsClass row = new EditsClass(res.getString("staffId"), res.getString("publicationId"));
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


    public static  ArrayList<PublicationClass> selectEditorPublication(String staffId){
        try{

            Connection conn = DBConnect.getConnection();
            ArrayList<PublicationClass> output = new ArrayList<>();
            String query = "Select * from publication left outer join book left outer join issue where publication.publicationId IN (Select publicationId from edits where staffId=" + staffId +")";
            Statement stat = conn.createStatement();
            ResultSet res =  stat.executeQuery(query);

            while(res.next()){
                PublicationClass row = new PublicationClass(res.getString("publicationId"), res.getString("title"), res.getString("periodicity"), res.getString("topics"));
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
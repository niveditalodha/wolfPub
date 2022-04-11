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
import wolfPubDB.classes.ReportClass;
import wolfPubDB.taskAndOperations.getReport;
import java.util.Arrays;
import java.util.List;

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

            List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "publicationId",
                "title",
                "periodicity",
                "topics",
                "publicationId",
                "isbn",
                "publicationDate",
                "edition",
                "publicationId",
                "issueDate",
                "type"
        ));

        String query = "select * from publication left outer join book on publication.publicationId = book.publicationId left outer join issue on publication.publicationId = issue.publicationId where publication.publicationId in (select publicationId from edits where staffId = '"+staffId+"');";

        return getReport(query, resultKeys);

        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import wolfPubDB.classes.EditsClass;
import wolfPubDB.connect.*;
import wolfPubDB.classes.ReportClass;

import java.util.Arrays;
import java.util.List;

import static wolfPubDB.taskAndOperations.Report.getReport;

public class Edits {

    public static ArrayList<EditsClass> selectEdits() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from edits");
            ArrayList<EditsClass> output = new ArrayList<>();
            while (res.next()) {
                EditsClass row = new EditsClass(res.getString("staffId"), res.getString("publicationId"));
                output.add(row);
            }
            conn.close();
            System.out.println("staffId\t\tpublicationId");
            return output;
        } catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            return null;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            return null;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }finally{
                conn.close();
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


    public static ReportClass selectEditorPublication(String staffId) {
        try {

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

            String query = "select * from publication left outer join book on publication.publicationId = book.publicationId left outer join issue on publication.publicationId = issue.publicationId where publication.publicationId in (select publicationId from edits where staffId = '" + staffId + "');";

            return getReport(query, resultKeys);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
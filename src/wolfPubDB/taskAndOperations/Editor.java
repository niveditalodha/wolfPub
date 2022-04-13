package wolfPubDB.taskAndOperations;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.EditorClass;
import wolfPubDB.connect.*;

public class Editor {
    
    public static ArrayList<EditorClass> selectEditor() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from editor");
            ArrayList<EditorClass> output = new ArrayList<>();
            while (res.next()) {
                EditorClass row = new EditorClass(res.getString("staffId"));
                output.add(row);
            }
            conn.close();
            System.out.println("staffId");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }
}

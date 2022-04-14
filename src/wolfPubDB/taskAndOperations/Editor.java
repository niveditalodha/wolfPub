package wolfPubDB.taskAndOperations;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
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
}

package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.AuthorClass;

public class Author{

    public static ArrayList<AuthorClass> selectAuthor() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from author");
            ArrayList<AuthorClass> output = new ArrayList<>();
            while (res.next()) {
                AuthorClass row = new AuthorClass(res.getString("staffId"));
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
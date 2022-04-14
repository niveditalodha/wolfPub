package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.StaffClass;
import wolfPubDB.connect.*;



public class Staff {
    public static ArrayList<StaffClass> selectStaff() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from staff");
            ArrayList<StaffClass> output = new ArrayList<>();
            while (res.next()) {
                StaffClass row = new StaffClass(res.getString("staffId"), res.getString("name"), res.getString("type"));
                output.add(row);
            }
            System.out.println("staffId\t\tname\t\ttype");
            conn.close();
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


    public static ArrayList<StaffClass> selectStaff(Integer staffId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from staff where staffId = '" +  staffId+"'");
            ArrayList<StaffClass> output = new ArrayList<>();
            while (res.next()) {
                StaffClass row = new StaffClass(res.getString("staffId"), res.getString("name"), res.getString("type"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean addAuthor(String staffId, String name, String type) throws SQLException{
        //Transaction
        Connection conn = DBConnect.getConnection();
        conn.setAutoCommit(false);
        boolean t1 = false;
        boolean t2 = false;
        try {
            String query = "insert into staff(staffId, name, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            t1 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            String query2 = "insert into author values (?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            t2 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (t1 && t2){
            conn.commit();
            System.out.println("Transaction Successful");
            conn.setAutoCommit(true);
            conn.close();
            return true;
        }
        else{
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.setAutoCommit(true);
            conn.close();
            return false;
        }
    }

    public static boolean addEditor(String staffId, String name, String type) throws SQLException {
        //Transaction
        Connection conn = DBConnect.getConnection();
        conn.setAutoCommit(false);
        boolean t1 = false;
        boolean t2 = false;
        try {
            String query = "insert into staff(staffId, name, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            t1 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try{
            String query2 = "insert into editor values (?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            t2 = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (t1 && t2){
            conn.commit();
            System.out.println("Transaction Successful");
            conn.setAutoCommit(true);
            conn.close();
            return true;
        }
        else{
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.setAutoCommit(true);
            conn.close();
            return false;
        }
    }



    public static Boolean updateStaff(String staffId, String name, String type) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update staff set name=?, type=? where staffId =" + staffId;
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, name);
            stat.setString(2, type);
            stat.setString(3, staffId);

            stat.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean deleteStaff(String staffId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM staff WHERE staffId= " + staffId);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
package wolfPubDB.taskAnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wolfPubDB.classes.Staff;
import wolfPubDB.connect.*;



public class Staff {
    public static ArrayList<Staff> selectStaff() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from staff");
            ArrayList<Staff> output = new ArrayList<>();
            while (res.next()) {
                Staff row = new Staff(res.getString("staffId"), res.getString("name"), res.getString("type"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static ArrayList<Staff> selectStaff(Integer staffId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from staff where staffId = " +  staffId);
            ArrayList<Staff> output = new ArrayList<>();
            while (res.next()) {
                Staff row = new Staff(res.getString("staffId"), res.getString("name"), res.getString("type"));
                output.add(row);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    public static boolean addAuthor(String staffId, String name, String type) {
        boolean state = false;
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into staff(staffId, name, type) values (?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            String query2 = "insert into author values(?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            conn.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean addEditor(String staffId, String name, String type) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into staff(staffId, name, type) values (?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.executeUpdate();
            String query2 = "insert into editor values (?)";
            PreparedStatement stat2 = conn.prepareStatement(query2);
            stat2.setString(1, staffId);
            stat2.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
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
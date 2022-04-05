package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.Distributors;

public class Distributors{

    public static ArrayList<Distributors> selectDistributors() throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors");
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Distributors> selectDistributorsByDistributorId(string distributorId) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where distributorId="+distributorId);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<Distributors> selectDistributorsByName(string name) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where name="+name);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Distributors> selectDistributorsByType(string type) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where type="+type);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<Distributors> selectDistributorsByBalance(float balance) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where balance="+balance);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Distributors> selectDistributorsByPhone(string phone) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where phone="+phone);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Distributors> selectDistributorsByCity(string city) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where city="+city);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Distributors> selectDistributorsByStreet(string street) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where street="+street);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static ArrayList<Distributors> selectDistributorsByContactPerson(string contactPerson) throws SQLException{
        try{
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ArrayList<Distributors> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where contactPerson="+contactPerson);
            while (res.next()){
                Distributors d = new Distributors(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            conn.close();
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Boolean addDistributor(String distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) throws SQLException{
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into distributors(distributorId, name, type, balance, phone, city, stret, contactPerson) values (?,?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, distributorId);
            stat.setString(2, name);
            stat.setString(3, type);
            stat.setFloat(4, balance);
            stat.setString(5, phone);
            stat.setString(6, city);
            stat.setString(7, street);
            stat.setString(8, contactPerson);
            stat.executeUpdate();
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }   


    public static Boolean updateDistributors(String distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) throws SQLException{
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update distributors set name = ?, type = ?, balance = ?, phone = ?, city = ?, street = ?, contactPerson = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, name);
            stat.setString(2, type);
            stat.setFloat(3, balance);
            stat.setString(4, phone);
            stat.setString(5, city);
            stat.setString(6, street);
            stat.setString(7, contactPerson);
            stat.setString(8, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from ditributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                conn.close()
                return  true;
            }
            conn.close()
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }


    public static Boolean deleteDistributors(String distributorId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM distributors WHERE distributorId= " + distributorId);
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
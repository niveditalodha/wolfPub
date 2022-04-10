package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.DistributorsClass;

public class Distributors{

    public static ArrayList<DistributorsClass> selectDistributors() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors");
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static ArrayList<DistributorsClass> selectDistributorsByDistributorId(String distributorId) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where distributorId="+distributorId);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }
    
    public static ArrayList<DistributorsClass> selectDistributorsByName(String name) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where name="+name);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static ArrayList<DistributorsClass> selectDistributorsByType(String type) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where type="+type);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }
    
    public static ArrayList<DistributorsClass> selectDistributorsByBalance(Float balance) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where balance="+balance);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static ArrayList<DistributorsClass> selectDistributorsByPhone(String phone) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where phone="+phone);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static ArrayList<DistributorsClass> selectDistributorsByCity(String city) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where city="+city);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static ArrayList<DistributorsClass> selectDistributorsByStreet(String street) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where street="+street);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }
    
    public static ArrayList<DistributorsClass> selectDistributorsByContactPerson(String contactPerson) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try{
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery("Select * from distributors where contactPerson="+contactPerson);
            while (res.next()){
                DistributorsClass d = new DistributorsClass(res.getString("distributorId"), res.getString("name"), res.getString("type"), res.getFloat("balance"), res.getString("phone"), res.getString("city"), res.getString("street"), res.getString("contactPerson"));
                output.add(d);
            }
            return output;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally{
            conn.close();
        }
    }

    public static Boolean addDistributor(String distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try {
            System.out.println("Inside Distr");
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
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            
            conn.close();
        }
    }   

    public static Boolean updateDistributors(String distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try {
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
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            conn.close();
        }
    }    

    public static Boolean updateDistributorName(String distributorId, String name) throws SQLException{
        
        Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set name = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, name);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                conn.close();
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    

    public static Boolean updateDistributorType(String distributorId, String type) throws SQLException{
        
            Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set type = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, type);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    

    public static Boolean updateDistributorPhone(String distributorId, String phone) throws SQLException{
        
            Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set phone = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, phone);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    

    public static Boolean updateDistributorCity(String distributorId, String city) throws SQLException{
        
            Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set city = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, city);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    

    public static Boolean updateDistributorStreet(String distributorId, String street) throws SQLException{
        
            Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set street = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, street);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    

    public static Boolean updateDistributorContactPerson(String distributorId, String contactPerson) throws SQLException{
        
            Connection conn = DBConnect.getConnection();
        try {
            String query = "Update distributors set contactPerson = ? where distributorId = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, contactPerson);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            
            conn.close();
        }
    }    


    public static Boolean updateDistributorBalance(String distributorId, Float balance) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            String query = "update distributors set balance = ? where distributorId = ?;";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setFloat(1, balance);
            stat.setString(2, distributorId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from distributors where distributorId="+distributorId);
            int count = 0;
            while (res.next()) {
                count = res.getInt("total");
            }
            conn.commit();
            if (count!=0){
                return  true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        finally{
            conn.close();
        }
    }

    public static Boolean deleteDistributors(String distributorId) throws SQLException {
        Connection conn = DBConnect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM distributors WHERE distributorId= " + distributorId);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        finally{
            conn.close();
        }
    }

}

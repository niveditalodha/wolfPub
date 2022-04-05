package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.Issue;

public class Orders {

    public static ArrayList<Orders> selectOrders() {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders");
            ArrayList<Orders> output = new ArrayList<>();
            while (res.next()) {
                Orders p = new Orders(res.getString("orderId"), Date.valueOf(res.getDate("deadline")), res.getString("price"), Date.valueOf(res.getDate("orderDate")), res.getString("noOfCopies"), res.getString("shippingCost"), res.getString("publicationId"), res.getString("distributorId"));
                output.add(p);
            }
            conn.close()
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Book> selectOrders(String orderId) throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Orders> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from orders where order="+orderId);
            while (res.next()) {
                Issue p = new Issue(res.getString("orderId"), Date.valueOf(res.getDate("deadline")), res.getString("price"), Date.valueOf(res.getDate("orderDate")), res.getString("noOfCopies"), res.getString("shippingCost"), res.getString("publicationId"), res.getString("distributorId"));
                output.add(p);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean addOrders(String orderId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) throws SQLException{
        try {
            Connection conn = DBConnect.getConnection();
            String query = "insert into orders(orderId, name, type, balance, phone, city, stret, contactPerson) values (?,?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, orderId);
            stat.setDate(2, deadline);
            stat.setString(3, price);
            stat.setDate(4, orderDate);
            stat.setString(5, noOfCopies);
            stat.setString(6, shippingCost);
            stat.setString(7, publicationId);
            stat.setString(8, distributorId);
            stat.executeUpdate();
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean updateOrders(String publicationId, Date issueDate String type) {
         try {
            Connection conn = DBConnect.getConnection();
            String query = "Update issue set deadline = ?, price = ?, orderDate = ?, noOfCopies = ?, shippingCost = ?, publicationId = ?, distributorId = ?,  where orderId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setDate(1, deadline);
            stat.setString(2, price);
            stat.setDate(3, orderDate);
            stat.setString(4, noOfCopies);
            stat.setString(5, shippingCost);
            stat.setString(6, publicationId);
            stat.setString(7, distributorId);
            stat.setString(8, orderId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as total from issue where publicationId=" + publicationId);
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

    public static Boolean deleteOrders(String orderId) {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM orders WHERE orderId= " + orderId);
            conn.close()
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
}

package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.Orders;

public class Orders{

    public static ArrayList<Orders> selectOrder() {
        try {
            Connection conn = DbConnect.getConnection();
            ArrayList<Orders> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from orders");
            while (res.next()) {
                Orders pub = new Orders(res.getString("orderId"), Date.valueOf(res.getDate("deadline")), Float.valueOf(res.getfloat("price")), Date.valueOf(res.getDate("orderDate")), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getfloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Orders> selectOrderByDate(Date orderDate) {
        try {
            Connection conn = DbConnect.getConnection();
            ArrayList<Orders> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where orderDate = " + orderDate);
            while (res.next()) {
                Orders pub = new Orders(res.getString("orderId"), Date.valueOf(res.getDate("deadline")), Float.valueOf(res.getfloat("price")), Date.valueOf(res.getDate("orderDate")), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getfloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean addOrders(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) {
        try {
            Connection conn = DbConnect.getConnection();
            String query = "insert into orders(orderId, deadline, price, orderDate, noOfCopies, shippingCost, publicationId, distributorId) values (?,?,?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, orderId);
            stat.setDate(2, deadline);
            stat.setFloat(3, price);
            stat.setDate(4, orderDate);
            stat.setInt(5, noOfCopies);
            stat.setFloat(6, shippingCost);
            stat.setString(7, publicationId);
            stat.setString(8, distributorId);
            stat.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            conn.close();
            return false;
        }
    }

    public static Boolean updateOrder(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) {
        try {
            Connection conn = DBConnect.getConnection();
            String query = "Update orders set deadline = ?, price = ?, orderDate = ?, noOfCopies = ?, shippingCost = ?, publicationId = ?, distributorId = ? where orderId =?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setDate(1, deadline);
            stat.setFloat(2, price);
            stat.setDate(3, orderDate);
            stat.setInt(4, noOfCopies);
            stat.setFloat(5, shippingCost);
            stat.setString(6, publicationId);
            stat.setString(7, distributorId);
            stat.setString(8, orderId);
            stat.executeUpdate();
            ResultSet res = stat.executeQuery("Select count(*) as orders from issue where orderId="+orderId);
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



}
package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.connect.*;
import wolfPubDB.classes.OrdersClass;

public class Orders{

    public static ArrayList<OrdersClass> selectOrder() {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from orders");
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByDistributorId(String distributorId) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where distributorId = " + distributorId);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByDate(Date orderDate) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where orderDate = " + orderDate);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByDeadline(Date deadline) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where deadline = " + deadline);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByPrice(Float price) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where orderDate = " + price);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByNoOfCopies(Integer noOfCopies) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where noOfCopies = " + noOfCopies);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByShippingCosts(Float shippingCost) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where shippingCost = " + shippingCost);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<OrdersClass> selectOrderByPublicationId(String publicationId) {
        try {
            Connection conn = DBConnect.getConnection();
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("Select * from orders where publicationId = " + publicationId);
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
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
            Connection conn = DBConnect.getConnection();
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
                conn.close();
                return  true;
            }
            conn.close();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
        }

    public static Boolean deleteOrders(String orderId) {

        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM orders WHERE orderId= " + orderId);
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }



}

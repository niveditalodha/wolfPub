package wolfPubDB.taskAndOperations;

import java.sql.*;
import java.util.ArrayList;

import wolfPubDB.connect.*;
import wolfPubDB.classes.OrdersClass;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the Orders.
 */

public class Orders {

    /**
     * Method for viewing data in the orders table.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static ArrayList<OrdersClass> selectOrder() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            ArrayList<OrdersClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from orders");
            while (res.next()) {
                OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
                output.add(pub);
            }
            conn.close();
            System.out.println("orderId\t\tdeadline\tprice\t\torderDate\tnoOfCopies\tshippingCost\tpublicationId\tdistributorId");
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

    /**
     * Method for inserting data in the orders table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean addOrders(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
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

    /**
     * Method for updating data in the orders table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean updateOrder(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) throws SQLException{
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

            conn.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method for deleting data in the orders table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean deleteOrders(String orderId) throws SQLException {

        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM orders WHERE orderId= '" + orderId + "'");
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    /**
     * Method for generating bill for distributorbased on order.
     * Connects to the DB, Creates an SQL query string, updates balance for distributor and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 

    public static boolean billDistributorForOrder(String orderId) throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {
            String query = "update distributors set balance = balance + ? where distributorId = ?";
            PreparedStatement st = conn.prepareStatement(query);
            String query1 = "select noOfCopies, price, shippingCost, distributorId from orders where orderId = '" + orderId + "'";

            Statement stat = conn.createStatement();
            float price = 0;
            float shippingCost = 0;
            Integer noOfCopies = 0;
            String distributorId = "";
            ResultSet rs1 = stat.executeQuery(query1);
            while (rs1.next()) {
                noOfCopies = rs1.getInt("noOfCopies");
                price = rs1.getFloat("price");
                shippingCost = rs1.getFloat("shippingCost");
                distributorId = rs1.getString("distributorId");
            }
            float balance = (noOfCopies * price) + shippingCost;
            st.setFloat(1, balance);
            st.setString(2, distributorId);

            st.executeUpdate();

            return true;
        } catch(SQLIntegrityConstraintViolationException ex){
            System.out.println("Foreign key constrain violated!!!");
            
            return false;
        } catch(SQLSyntaxErrorException ex){
            System.out.println("Invalid SQL syntax!!!");
            return false;
        }catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally{
                conn.close();
        }
    }

    //APIs not needed --Nivedita
    //4/10 1:00PM

    // public static ArrayList<OrdersClass> selectOrderByDistributorId(String distributorId) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where distributorId = " + distributorId);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByDate(Date orderDate) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where orderDate = " + orderDate);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByDeadline(Date deadline) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where deadline = " + deadline);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByPrice(Float price) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where orderDate = " + price);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByNoOfCopies(Integer noOfCopies) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where noOfCopies = " + noOfCopies);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByShippingCosts(Float shippingCost) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where shippingCost = " + shippingCost);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public static ArrayList<OrdersClass> selectOrderByPublicationId(String publicationId) {
    //     try {
    //         Connection conn = DBConnect.getConnection();
    //         ArrayList<OrdersClass> output = new ArrayList<>();
    //         Statement stat = conn.createStatement();
    //         ResultSet res = stat.executeQuery("Select * from orders where publicationId = " + publicationId);
    //         while (res.next()) {
    //             OrdersClass pub = new OrdersClass(res.getString("orderId"), res.getDate("deadline"), Float.valueOf(res.getFloat("price")), res.getDate("orderDate"), Integer.valueOf(res.getInt("noOfCopies")), Float.valueOf(res.getFloat("shippingCost")), res.getString("publicationId"), res.getString("distributorId"));
    //             output.add(pub);
    //         }
    //         conn.close();
    //         return output;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

}



package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Statement;

import wolfPubDB.classes.PaymentClass;
import wolfPubDB.connect.*;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to the Payment.
 */

public class Payment{

    /**
     * Method for viewing data in the payment table.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static ArrayList<PaymentClass> selectPayment() throws SQLException{
        Connection conn = DBConnect.getConnection();
        try {   
            ArrayList<PaymentClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from payment");
            while (res.next()) {
                PaymentClass chp = new PaymentClass(res.getString("staffId"), res.getDate("paymentDate"), Integer.valueOf(res.getInt("amount")), res.getDate("paymentClaimedDate"));
                output.add(chp);
            }
            conn.close();
            System.out.println("staffId\t\tpaymentDate\tamount\t\tpaymentClaimedDate");
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
     * Method for viewing data in the payment table based on staffId.
     * Connects to the DB, Creates an SQL query string and returns the results an Arraylist.
     *
     * @return Returns an ArrayList output
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static ArrayList<PaymentClass> selectPayment(String staffId) throws SQLException{
        try {   
            Connection conn = DBConnect.getConnection();
            ArrayList<PaymentClass> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from payment where staffId='"+staffId+"'");
            while (res.next()) {
                PaymentClass chp = new PaymentClass(res.getString("staffId"), res.getDate("paymentDate"), Integer.valueOf(res.getInt("amount")), res.getDate("paymentClaimedDate"));
                output.add(chp);
            }
            conn.close();
            System.out.println("staffId\t\tpaymentDate\tamount\t\tpaymentClaimedDate");
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method for inserting data in the payment table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static boolean addPayment(String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate) throws SQLException{
        Connection conn = null;
        try{
            conn = DBConnect.getConnection();

            String query = "INSERT INTO payment(staffId, paymentDate, amount, paymentClaimedDate) VALUES(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setDate(2, paymentDate);
            stat.setInt(3, amount);
            stat.setDate(4, paymentClaimedDate);
            stat.executeUpdate();

            
            System.out.println("Transaction Successful");
            conn.close();
            return true;
        }
        catch (SQLException ex) {
            System.out.println("Transaction Failed");
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.close();
            }
        }
    }

    /**
     * Method for updating data in the payment table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean updatePayment(String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate) throws SQLException{
        int count = 0;
        try{
            Connection conn = DBConnect.getConnection();
            String query = "Update payment set amount = ?, paymentClaimedDate = ? where staffId =? and paymentDate=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, amount);
            stat.setDate(2, paymentClaimedDate);
            stat.setString(2, staffId);
            stat.setDate(2, paymentDate);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from payment where staffId='"+staffId+"' and paymentDate='"+(paymentDate)+"'");
            while (res.next()) {
                count = res.getInt("total");
            }
            if (count!=0){
                conn.close();
                return  true;
            }
            conn.close();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return Boolean.valueOf(false);
        }
    }

    /**
     * Method for deleting data in the payment table.
     * Connects to the DB, Creates an SQL query string and returns boolean value.
     *
     * @return Returns boolean
     * @throws SQLException For handling any DB related runtime exceptions.
     */ 
    public static Boolean deletePayment(String staffId, Date paymentDate) throws SQLException {
        try {
            Connection conn = DBConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM payment WHERE staffId= '"+staffId+"' and paymentDate='"+(paymentDate)+"'");
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
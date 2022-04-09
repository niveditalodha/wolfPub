package wolfPubDB.taskAndOperations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import wolfPubDB.classes.PaymentClass;
import wolfPub.connect.*;

public class chapters{

    public static ArrayList<Payment> selectPayment() throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Payment> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from payment");
            while (res.next()) {
                Payment chp = new Payment(res.getString("staffId"), Date.valueOf(res.getDate("paymentDate")), Integer.valueOf(res.getInt("amount")), Date.valueOf(res.getDate("paymentClaimedDate")));
                output.add(chp);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Payment> selectPayment(String staffId) throws SQLException{
        try {   
            Connection conn = DbConnect.getConnection();
            ArrayList<Payment> output = new ArrayList<>();
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("select * from payment where staffId="+staffId);
            while (res.next()) {
                Payment chp = new Payment(res.getString("staffId"), Date.valueOf(res.getDate("paymentDate")), Integer.valueOf(res.getInt("amount")), Date.valueOf(res.getDate("paymentClaimedDate")));
                output.add(chp);
            }
            conn.close();
            return output;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean addPayment(String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate) throws SQLException{
        Connection conn = null;
        boolean t1 = false;
        try{
            conn = DbConnect.getConnection();
            conn.setAutoCommit(false);
            String query = "INSERT INTO payment(staffId, paymentDate, amount, paymentClaimedDate) VALUES(?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, staffId);
            stat.setDate(2, paymentDate);
            stat.setInt(3, amount);
            stat.setDate(2, paymentClaimedDate);
            stat.executeUpdate();

            t1 = true;

            if (t1){
                conn.commit();
                System.out.println("Transaction Successful");
                conn.close();
                return true;
            }
            else{
                conn.rollback();
                System.out.println("Transaction Failed");
                conn.close();
                return false;
            }
        }
        catch (SQLException ex) {
            conn.rollback();
            System.out.println("Transaction Failed");
            conn.close();
            return false;
        } finally {
            if(conn != null){
                conn.setAutoCommit(true);
                conn.close();
            }
        }
    }


    public static Boolean updatePayment(String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate) throws SQLException{
        int count = 0;
        try{
            Connection conn = DbConnect.getConnection();
            String query = "Update payment set amount = ?, paymentClaimedDate = ? where staffId =? and paymentDate=?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, amount);
            stat.setDate(2, paymentClaimedDate);
            stat.setString(2, staffId);
            stat.setDate(2, paymentDate);
            stat.executeUpdate();

            ResultSet res = stat.executeQuery("select count(*) as total from payment where staffId="+staffId+" and paymentDate="+Date.toString(paymentDate));
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

    public static Boolean deletePayment(String staffId, Date paymentDate) throws SQLException {
        try {
            Connection conn = DbConnect.getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate("DELETE FROM payment WHERE staffId= "+staffId+" and paymentDate="+Date.toString(paymentDate));
            conn.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
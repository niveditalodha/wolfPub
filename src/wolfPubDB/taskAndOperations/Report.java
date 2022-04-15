package wolfPubDB.taskAndOperations;

import wolfPubDB.classes.ReportClass;
import wolfPubDB.classes.ResultClass;
import wolfPubDB.connect.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that contains all the APIs for generating the tasks and operations
 * related to Report Menu.
 */
public class Report {

    /**
     * A reusable method that takes the query, connects to the DB and returns
     * the results as an object.
     *
     * @param query SQL Query string
     * @param resultKeys List of column headers that are displayed while printing
     *                   the result table. The name and order of each key should
     *                   exactly match what we expect SQL queries to return.
     * @return @ReportClass object that contains @resultKeys and result rows.
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getReport(String query, List<String> resultKeys) throws SQLException {
        Connection conn = DBConnect.getConnection();

        try {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(query);
            List<ResultSet> resultList = new ArrayList<>();

            ResultClass results = new ResultClass();
            while (res.next()) {
                resultList.add(res);
                results.addRow(res, resultKeys.size());
            }

            ReportClass report = new ReportClass(resultKeys, results);
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.close();
        }

    }

    /**
     * Method for generating report for number and total price of copies of each
     * publication bought per distributor per month.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyPublicationReport() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Publication Title",
                "Distributor",
                "Total Copies",
                "Total Price"
        ));

        String query = "SELECT MONTH(o.orderDate) as Month, " +
                "YEAR(o.orderDate) as Year, p.title as 'Publication Title', " +
                "d.name AS 'Distributor', SUM(o.noOfCopies) as 'Total Copies', " +
                "SUM(o.price*o.noOfCopies) as 'Total Price' " +
                "FROM orders AS o, publication AS p , distributors AS d " +
                "WHERE p.publicationId=o.publicationId and " +
                "d.distributorId=o.distributorId " +
                "GROUP BY MONTH(o.orderDate), " +
                "YEAR(o.orderDate), o.distributorId, " +
                "p.publicationId;";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total monthly publishing house revenue
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyPublishingRevenue() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Total Revenue"
        ));

        String query = "select sum(revenue) as TotalRevenue from "+
                        "(select sum(noOfCopies*price)-balance as revenue from orders o "+
                        "join distributors d on o.distributorId=d.distributorId group by o.distributorId) as TotalRevenue";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total monthly publishing house expenses.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getTotalExpenses() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "TotalExpense"
        ));

        String query = "select (select sum(amount) from payment)+ (select sum(shippingCost) from orders) as "+
                        "TotalExpense";


        return getReport(query, resultKeys);
    }
//     /**
//      * Method for generating report for Total monthly publishing house salary
//      * expenses.
//      * Creates an SQL query string and calls @getReport to run that.
//      *
//      * @return Returns the result object received from @getReport
//      * @throws SQLException For handling any DB related runtime exceptions.
//      */
//     public static ReportClass getMonthlySalaryCost() throws SQLException {
//         List<String> resultKeys = new ArrayList<>(Arrays.asList(
//                 "Month",
//                 "Year",
//                 "Salary Cost"
//         ));

//         String query = "SELECT MONTH(p.paymentDate) as Month, " +
//                 "YEAR(p.paymentDate) as Year, SUM(p.amount) " +
//                 "as 'Salary Cost' " +
//                 "FROM payment as p " +
//                 "GROUP BY MONTH(p.paymentDate), " +
//                 "YEAR(p.paymentDate);";

//         return getReport(query, resultKeys);
//     }

    /**
     * Method for generating report for Total current number of distributors.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getDistributorCount() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "No. of Distributors"
        ));

        String query = "SELECT COUNT(distributorId) AS 'No. of Distributors' FROM distributors;";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total revenue per city (since inception).
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getRevenuePerCity() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "City",
                "Total Revenue per City"
        ));

        String query = "SELECT d.city as City, SUM (o.price*o.noOfCopies) AS 'Total Revenue per City'  " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON o.distributorId=d.distributorId " +
                "GROUP BY d.city;";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total revenue per distributor (since
     * inception).
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getRevenuePerDistributor() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Distributor ID",
                "Name",
                "Total Revenue per Distributor"
        ));

        String query = "SELECT d.distributorId as 'Distributor ID' , d.name as 'Name', " +
                "sum(o.price*o.noOfCopies) AS 'Total Revenue per Distributor' " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON " +
                "o.distributorId=d.distributorId " +
                "GROUP BY o.distributorId;";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total revenue per location (since
     * inception).
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getRevenuePerLocation() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Street",
                "City",
                "Total Revenue per Location"
        ));

        String query = "SELECT d.street as 'Street', d.city as 'City', " +
                "SUM(o.price*o.noOfCopies) AS 'Total Revenue per Location' " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON " +
                "o.distributorId=d.distributorId " +
                "GROUP BY d.city, d.street;";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total payments to editors and authors
     * per time period.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Total Payments per Month"
        ));

        String query = "SELECT MONTH (paymentDate) AS Month, " +
                "YEAR (paymentDate) AS Year, SUM (amount) " +
                "AS 'Total Payments per Month' " +
                "FROM payment " +
                "GROUP BY MONTH (paymentDate), YEAR (paymentDate);";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total payments to book editors.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyEditorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Editors"
        ));

        String query = "SELECT MONTH(paymentDate) AS Month, "+
                "YEAR(paymentDate) AS Year, sum(amount) AS 'Monthly Payments to Editors' "+
                "FROM payment where staffId in (select distinct(staffId) from editor) "+
                "GROUP BY MONTH(paymentDate), YEAR(paymentDate);";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total payments to book authors.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyBookAuthorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Book Authors"
        ));

        String query = "SELECT MONTH(paymentDate) AS Month, "+
                "YEAR(paymentDate) AS Year, sum(amount) AS 'Monthly Payments to Book Authors' "+
                "FROM payment where staffId in (select distinct(staffId) from writesbook) "+
                "GROUP BY MONTH(paymentDate), YEAR(paymentDate);";

        return getReport(query, resultKeys);
    }

    /**
     * Method for generating report for Total payments to article authors.
     * Creates an SQL query string and calls @getReport to run that.
     *
     * @return Returns the result object received from @getReport
     * @throws SQLException For handling any DB related runtime exceptions.
     */
    public static ReportClass getMonthlyArticleAuthorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Article Authors"
        ));

        String query = "SELECT MONTH(paymentDate) AS Month, "+
                        "YEAR(paymentDate) AS Year, sum(amount) AS 'Monthly Payments to Article Authors' "+
                        "FROM payment where staffId in (select distinct(staffId) from writesarticle) "+
                        "GROUP BY MONTH(paymentDate), YEAR(paymentDate);";

        return getReport(query, resultKeys);
    }

}


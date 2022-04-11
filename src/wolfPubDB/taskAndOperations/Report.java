package wolfPubDB.taskAndOperations;

import wolfPubDB.classes.DistributorsClass;
import wolfPubDB.classes.ReportClass;
import wolfPubDB.connect.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report {
    public static ReportClass getReport(String query, List<String> resultKeys) throws SQLException {
        Connection conn = DBConnect.getConnection();

        try {
            Statement stat = conn.createStatement();
            ArrayList<DistributorsClass> output = new ArrayList<>();
            ResultSet res = stat.executeQuery(query);
            List<ResultSet> resultList = new ArrayList<>();

            while (res.next()) {
                resultList.add(res);
            }

            ReportClass report = new ReportClass(resultKeys, resultList);
            return report;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            conn.close();
        }

    }

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
                "YEAR(o.orderDate) as Year, p.title as ”Publication Title”, " +
                "d.name AS ”Distributor”, SUM(o.noOfCopies) as ”Total Copies”, " +
                "SUM(o.price*o.noOfCopies) as ”Total Price” " +
                "FROM orders AS o, publication AS p , distributors AS d " +
                "WHERE p.publicationId=o.publicationId and " +
                "d.distributorId=o.distributorId " +
                "GROUP BY MONTH(o.orderDate), " +
                "YEAR(o.orderDate), o.distributorId, " +
                "p.publicationId;";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyPublishingRevenue() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Revenue"
        ));

        String query = "SELECT MONTH (orderDate) as Month, YEAR " +
                "(orderDate) as Year, SUM (price * noOfCopies) as ”Revenue” " +
                "FROM orders";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyShippingCost() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Shipping Cost"
        ));

        String query = "SELECT MONTH(o.orderDate) as Month, YEAR(o.orderDate) as Year, " +
                "SUM(o.shippingCost*o.noOfCopies) as ”Shipping Cost” " +
                "FROM orders as o " +
                "GROUP BY MONTH(o.orderDate), YEAR(o.orderDate);";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlySalaryCost() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Salary Cost"
        ));

        String query = "SELECT MONTH(p.paymentDate) as Month, " +
                "YEAR(p.paymentDate) as Year, SUM(p.amount) " +
                "as ”Salary Cost” " +
                "FROM payment as p " +
                "GROUP BY MONTH(p.paymentDate), " +
                "YEAR(p.paymentDate);";

        return getReport(query, resultKeys);
    }

    public static ReportClass getDistributorCount() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "No. of Distributors"
        ));

        String query = "SELECT COUNT(distributorId) AS ”No. of Distributors” FROM distributors;";

        return getReport(query, resultKeys);
    }

    public static ReportClass getRevenuePerCity() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "City",
                "Total Revenue per City"
        ));

        String query = "SELECT d.city as City, SUM (o.price*o.noOfCopies) AS ”Total Revenue per City”  " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON o.distributorId=d.distributorId " +
                "GROUP BY d.city;";

        return getReport(query, resultKeys);
    }

    public static ReportClass getRevenuePerDistributor() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Distributor ID",
                "Name",
                "Total Revenue per Distributor"
        ));

        String query = "SELECT d.distributorId as ”Distributor ID” , d.name as ”Name”, " +
                "sum(o.price*o.noOfCopies) AS ”Total Revenue per Distributor” " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON " +
                "o.distributorId=d.distributorId " +
                "GROUP BY o.distributorId;";

        return getReport(query, resultKeys);
    }

    public static ReportClass getRevenuePerLocation() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Street",
                "City",
                "Total Revenue per Location"
        ));

        String query = "SELECT d.street as ”Street”, d.city as ”City”, " +
                "SUM(o.price*o.noOfCopies) AS ”Total Revenue per Location” " +
                "FROM distributors AS d " +
                "INNER JOIN orders AS o ON " +
                "o.distributorId=d.distributorId " +
                "GROUP BY d.city, d.street;";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Total Payments per Month"
        ));

        String query = "SELECT MONTH (paymentDate) AS Month, " +
                "YEAR (paymentDate) AS Year, SUM (amount) " +
                "AS ”Total Payments per Month” " +
                "FROM payment " +
                "GROUP BY MONTH (paymentDate), YEAR (paymentDate);";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyEditorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Editors"
        ));

        String query = "SELECT MONTH(p.paymentDate) AS Month, " +
                "YEAR(p.paymentDate) AS Year, sum(amount) AS ”Monthly Payments to Editors” " +
                "FROM payment p " +
                "natural join editor e " +
                "GROUP BY MONTH(p.paymentDate), YEAR(p.paymentDate);";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyBookAuthorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Book Authors"
        ));

        String query = "SELECT MONTH(p.paymentDate) AS Month, YEAR(p.paymentDate) AS Year, " +
                "sum(amount) AS ”Monthly Payments to Book Authors” " +
                "FROM payment p " +
                "natural join writesbook " +
                "GROUP BY MONTH(p.paymentDate), YEAR(p.paymentDate);";

        return getReport(query, resultKeys);
    }

    public static ReportClass getMonthlyArticleAuthorPayments() throws SQLException {
        List<String> resultKeys = new ArrayList<>(Arrays.asList(
                "Month",
                "Year",
                "Monthly Payments to Article Authors"
        ));

        String query = "SELECT MONTH(p.paymentDate) AS Month, YEAR(p.paymentDate) AS Year, " +
                "sum(amount) AS ”Monthly Payments to Article Authors” " +
                "FROM payment p " +
                "natural join writesarticle " +
                "GROUP BY MONTH(p.paymentDate), YEAR(p.paymentDate);";

        return getReport(query, resultKeys);
    }

}

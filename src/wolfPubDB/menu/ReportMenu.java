package wolfPubDB.menu;

import wolfPubDB.classes.ReportClass;
import wolfPubDB.taskAndOperations.Report;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ReportMenu {

    public static void reportMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;
        while (true) {
            System.out.println("------ REPORT MENU ------");
            System.out.println("1. Report for number and total price of copies\n" +
                                "  of each publication bought per distributor\n" +
                                "  per month");
            System.out.println("2. Total monthly publishing house revenue");
            System.out.println("3. Total monthly publishing house expenses\n" +
                               "   (shipping cost and salaries)");
            System.out.println("4. Total current number of distributors");
            System.out.println("5. Total revenue per city (since inception)");
            System.out.println("6. Total revenue per distributor (since inception)");
            System.out.println("7. Total revenue per location (since inception)");
            System.out.println("8. Total payments to editors authors per time period");
            System.out.println("9. Total payments to editors authors per work\n" +
                               "   type (book authorship, article authorship,\n" +
                               "   editorial work)");

            int input = sc.nextInt();
            ReportClass report;

            switch (input) {
                case 1:
                    report = Report.getMonthlyPublicationReport();
                    ReportClass.printReport(report);
                    break;
                case 2:
                    report = Report.getMonthlyPublishingRevenue();
                    ReportClass.printReport(report);
                    break;
                case 3:
                    report = Report.getMonthlyShippingCost();
                    ReportClass.printReport(report);

                    System.out.println("____________________________");

                    report = Report.getMonthlySalaryCost();
                    ReportClass.printReport(report);
                    break;
                case 4:
                    report = Report.getDistributorCount();
                    ReportClass.printReport(report);
                    break;
                case 5:
                    report = Report.getRevenuePerCity();
                    ReportClass.printReport(report);
                    break;
                case 6:
                    report = Report.getRevenuePerDistributor();
                    ReportClass.printReport(report);
                    break;
                case 7:
                    report = Report.getRevenuePerLocation();
                    ReportClass.printReport(report);
                    break;
                case 8:
                    report = Report.getMonthlyPayments();
                    ReportClass.printReport(report);
                    break;
                case 9:
                    report = Report.getMonthlyEditorPayments();
                    ReportClass.printReport(report);
                    System.out.println("____________________________");

                    report = Report.getMonthlyBookAuthorPayments();
                    ReportClass.printReport(report);
                    System.out.println("____________________________");

                    report = Report.getMonthlyArticleAuthorPayments();
                    ReportClass.printReport(report);
                    break;
                default:
                    System.out.println("Enter a valid choice!");
            }

        }
    }


}
package wolfPubDB.menu;

import wolfPubDB.classes.ReportClass;
import wolfPubDB.taskAndOperations.Report;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class responsible for showing report generating menu options.
 */
public class ReportMenu {

    /**
     * Method that prints and handles the Report Menu operations.
     * It depends on {@link Report} class that have all the required APIs for
     * generating the report. This method acts as the View handler.
     *
     * @throws SQLException It handles Database related errors in case they occur
     */
    public static void reportMenu() throws SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;

        while (true) {
            System.out.println("------ REPORT MENU ------");
            System.out.println("1. Report for number and total price of copies\n" +
                    "  of each publication bought per distributor\n" +
                    "  per month");
            System.out.println("2. Total publishing house revenue");
            System.out.println("3. Total publishing house expenses\n" +
                    "   (shipping cost and salaries)");
            System.out.println("4. Total current number of distributors");
            System.out.println("5. Total revenue per city (since inception)");
            System.out.println("6. Total revenue per distributor (since inception)");
            System.out.println("7. Total revenue per location (since inception)");
            System.out.println("8. Total payments to editors and authors per time period");
            System.out.println("9. Total payments to editors and authors per work\n" +
                    "   type (book authorship, article authorship,\n" +
                    "   editorial work)");
            System.out.println("10. Go back to Main menu");

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
                    report = Report.getTotalExpenses();
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
                case 10:
                    MainMenu.main(main_args);
                    break;
                default:
                    System.out.println("Enter a valid choice!");
            }

        }
    }


}

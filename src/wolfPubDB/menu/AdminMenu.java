package wolfPubDB.menu;

import java.util.*;
import java.io.IOException;
import java.sql.SQLException;

public class AdminMenu {

    public static void adminMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;
        while (true) {
            System.out.println("Welcome to the ADMIN MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Publication Operations");
            System.out.println("2. Staff Operations");
            System.out.println("3. Orders Operations");
            System.out.println("4. Distributor Operations");
            System.out.println("5. Payment Operations");
            System.out.println("6. Reports");
            System.out.println("7. Display Table");
            System.out.println("8. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    PublicationMenu.publicationMenu();
                    break;
                case 2:
                    StaffMenu.staffMenu();
                    break;
                case 3:
                    OrderMenu.orderMenu();
                    break;
                case 4:
                    DistributorMenu.distributorMenu();
                    break;
                case 5:
                    PaymentMenu.paymentMenu();
                    break;
                case 6:
                    ReportMenu.reportMenu();
                    break;
                case 7:
                    Display.DisplayMenu();
                case 8:
                    MainMenu.main(main_args);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
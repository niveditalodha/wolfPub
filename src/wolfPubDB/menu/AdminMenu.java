package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;

import java.io.Scanner;
import java.io.IOException;
import java.sql.SQLException;

public class AdminMenu {

    public static void adminMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to the ADMIN MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Publication Operations");
            System.out.println("2. Staff Operations");
            System.out.println("3. Orders Operations");
            System.out.println("4. Distributor Operations");
            System.out.println("5. Payment Operations");
            System.out.println("6. Reports");
            System.out.println("7. Back to Main Menu");

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
                    MainMenu.main();
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
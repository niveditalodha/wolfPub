package wolfPubDB.menu;

import java.io.IOException;
import java.util.*;
import java.sql.*;

/**
 * Class responsible for showing landing menu options for the application.
 */

public class MainMenu {

    /**
     * Method that prints and handles the Main menu operations.
     * It provides a menu for all the users of the database
     * 
     * This method acts as the View handler.
     * 
     * It is the main function of the app where it initiates
     * It redirects to different user views
     */
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the WOLFPUB Database");
            System.out.println("Menu: Please select your option");
            System.out.println("1. ADMIN");
            System.out.println("2. STAFF");
            System.out.println("3. SALES");
            System.out.println("4. EXIT");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        AdminMenu.adminMenu();
                        break;
                    case 2:
                        StaffMenu.staffMenu();
                        break;
                    case 3:
                        SalesMenu.salesMenu();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                }
                System.out.println("Please enter a valid choice");
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        }

    }


}
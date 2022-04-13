package wolfPubDB.menu;

import java.io.IOException;
import java.util.*;
import java.sql.*;

public class MainMenu{

    /**
     * a function that connects to the DB main menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return mainMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
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
package wolfPubDB.menu;

import java.util.*;

public class SalesMenu{

     /**
     * a function that connects to the DB sales menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return salesMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void salesMenu (){
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        while (true) {
            System.out.println("Welcome to SALES Menu!!");
            System.out.println("Please select from the following!!");
            System.out.println("1. Distributor Operations");
            System.out.println("2. Order Operations");
            System.out.println("3. Reports");
            System.out.println("4. Back to Main Menu");
            int option = sc.nextInt();
            try {
                switch (option) {
                    case 1:
                        DistributorMenu.distributorMenu();
                        break;
                    case 2:
                        OrderMenu.orderMenu();
                        break;
                    case 3:
                        ReportMenu.reportMenu();
                        break;
                    case 4:
                        MainMenu.main(args);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}

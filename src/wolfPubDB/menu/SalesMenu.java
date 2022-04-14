package wolfPubDB.menu;

import java.util.*;

/**
 * Class responsible for showing menu options for Sales.
 */

public class SalesMenu{

    /**
     * Method that prints and handles the Sales Menu operations.
     * It depends on {@link DistributorMenu , @link OrderMenu , @link ReprotMenu} class that have all 
     * the required APIs for generating the results of Sales. 
     * 
     * This method acts as the View handler.
     * 
     * @throws NumberFormatException It handles and error if attempt is made to 
     *                  convert a string with an incorrect format to a numeric value.
     * @throws IOException It handles any Input/Output related errors in case they occur
     * @throws SQLException It handles Database related errors in case they occur
     * @throws IllegalArgumentException It handles errors thrown in order to indicate that 
     *                  a method has been passed an illegal argument. Like 2020-0-0 to a date
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
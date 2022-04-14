package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;

/**
 * Class responsible for showing menu options for Payment.
 */

public class PaymentMenu {

    /**
     * Method that prints and handles the Payment Menu operations.
     * It depends on {@link Payment} class that have all 
     * the required APIs for generating the results of payments. 
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

    public static void paymentMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        String staffId;
        Date paymentClaimedDate, paymentDate;
        Integer amount;

        while (true) {
            System.out.println("Welcome to the PAYMENT MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Payments to staff");
            System.out.println("2. Add Payment to staff");
            System.out.println("3. Display when each payment was claimed by staff");
            System.out.println("4. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Editor Table
                    Payment.selectPayment().forEach(System.out::println);
                    break;


                case 2:
                    // Add Payment
                    System.out.println("Enter String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                        paymentDate = Date.valueOf(args[1].trim());
                        amount = Integer.valueOf(args[2].trim());
                        paymentClaimedDate = Date.valueOf(args[3].trim());
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }

                    if (Payment.addPayment(staffId, paymentDate, amount, paymentClaimedDate)){
                        System.out.println("Addition Successful");
                    }
                    else{
                        System.out.println("Operation Failed");
                    }
                    return;


                case 3:
                    // Find when the payments were claimed by staff
                    System.out.println("Enter String staffId");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }

                    Payment.selectPayment(staffId).forEach(System.out::println);
                    return;


                case 4:
                    MainMenu.main(args);
                    break;


                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
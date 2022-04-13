package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
public class PaymentMenu {

    /**
     * a function that connects to the DB payment menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return paymentMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void paymentMenu() throws NumberFormatException, IOException, SQLException {
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
                    args = sc.next().split("[|]");
                    staffId = args[0];
                    paymentDate = Date.valueOf(args[1]);
                    amount = Integer.valueOf(args[2]);
                    paymentClaimedDate = Date.valueOf(args[3]);

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
                    args = sc.next().split("[|]");
                    staffId = args[0];

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
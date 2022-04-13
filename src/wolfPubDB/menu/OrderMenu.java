package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
public class OrderMenu {

    /**
     * a function that connects to the DB order menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return orderMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void orderMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        String distributorId,  orderId,publicationId;
        Date orderDate, deadline;
        Float shippingCost;
        Integer noOfCopies;
        Float price;

        while (true) {
            System.out.println("Welcome to the ORDERS MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Orders");
            System.out.println("2. Add Orders");
            System.out.println("3. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Editor Table
                    Orders.selectOrder().forEach(System.out::println);
                    break;
                case 2:
                    //Add orders
                    System.out.println("Enter String orderId, Date deadline, Float price, Date orderDate, Integer number of copies, Float shipping cost, String publicationId, String distributorId separated by |");
                    args = sc.next().split("[|]");
                    System.out.println(Arrays.toString((Object[]) args));
                    orderId = args[0];
                    deadline = Date.valueOf(args[1]);
                    price = Float.valueOf(Float.parseFloat(args[2]));
                    orderDate = Date.valueOf(args[3]);
                    noOfCopies = Integer.valueOf(Integer.parseInt(args[4]));
                    shippingCost = Float.valueOf(Float.parseFloat(args[5]));
                    publicationId = args[6];
                    distributorId = args[7];

                    if (Orders.addOrders(orderId, deadline, price, orderDate, noOfCopies, shippingCost, publicationId, distributorId).booleanValue()) {
                        System.out.println("Records Updated!!");
                    } else {
                        System.out.println("Updation Failed!!");
                    }
                    return;
                case 3:
                    MainMenu.main(args);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
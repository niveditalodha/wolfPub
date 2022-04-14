package wolfPubDB.menu;

import java.io.IOException;
import java.util.*;
import java.sql.Date;
import wolfPubDB.taskAndOperations.*;


/**
 * Class responsible for showing menu options for Distributors.
 */

public class DistributorMenu {

    /**
     * Method that prints and handles the Distributor Menu operations.
     * It depends on {@link Distributors and @link Orders} class that have all 
     * the required APIs for generating the results of distributors. 
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

    public static void distributorMenu() throws NumberFormatException, IOException, IllegalArgumentException {
        Float balance;
        String distributorId, name, type, phone,contactPerson,street,city, orderId,publicationId;
        Date orderDate, deadline;
        Float shippingCost;
        Integer noOfCopies;
        Float price;
        String input;
        String[] args;
        boolean exit_val = true;
        String[] main_args = null;
        while(exit_val) {
            try{
                System.out.println("Welcome to the DISTRIBUTORS MENU !!");
                System.out.println("Please select your option:");
                System.out.println("1. Show all distributors");
                System.out.println("2. Add Distributors");
                System.out.println("3. Update Distributor Details");
                System.out.println("4. Delete Distributor Details");
                System.out.println("5. Input orders from Distributors");
                System.out.println("6. Bill Distributor for an Order");
                System.out.println("7. Update outstanding balance of a Distributor");
                System.out.println("8. Back to Main");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        
                        Distributors.selectDistributors().forEach(System.out::println);
                        return;
                    case 2:
                        System.out.println("Enter String distributorId, String name, String type, Float balance, String phone, String contactPerson, String street, String City separated by |");
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            distributorId = args[0].trim();
                            name = args[1].trim();
                            type = args[2].trim();
                            balance = Float.valueOf(Float.parseFloat(args[3].trim()));
                            phone = args[4].trim();
                            contactPerson = args[5].trim();
                            street = args[6].trim();
                            city = args[7].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }


                        if(Distributors.addDistributor(distributorId, name, type, balance, phone, street, city, contactPerson))
                        {
                            System.out.println("Records Inserted!!");
                        }
                        else
                        {
                            System.out.println("Insertion Failed!!");
                        }
                        return;
                    case 3:

                        System.out.println("Enter String distributorId, String name, String type, Float balance, String phone, String contactPerson, String street, String City separated by |");
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            distributorId = args[0].trim();
                            name = args[1].trim();
                            type = args[2].trim();
                            balance = Float.valueOf(Float.parseFloat(args[3].trim()));
                            phone = args[4].trim();
                            contactPerson = args[5].trim();
                            street = args[6].trim();
                            city = args[7].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }
                        if (Distributors.updateDistributors(distributorId, name, type, balance, phone, street, city, contactPerson).booleanValue()) {
                            System.out.println("Records Updated!!");
                        } else {
                            System.out.println("Updation Failed!!");
                        }
                        return;
                    case 4:

                        System.out.println("Enter distributorId");
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            distributorId = args[0].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }

                        if(Distributors.deleteDistributors(distributorId)){
                            System.out.println("Records Updated!!");
                        } else {
                            System.out.println("Updation Failed!!");
                        }
                        return;
                    case 5:
                        System.out.println("Enter String orderId, Date deadline, Float price, Date orderDate (YYYY-MM-DD), Integer number of copies, Float shipping cost, String publicationId, String distributorId separated by |");
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            
                            orderId = args[0].trim();
                            deadline = Date.valueOf(args[1].trim());
                            price = Float.valueOf(Float.parseFloat(args[2].trim()));
                            orderDate = Date.valueOf(args[3].trim());
                            noOfCopies = Integer.valueOf(Integer.parseInt(args[4].trim()));
                            shippingCost = Float.valueOf(Float.parseFloat(args[5].trim()));
                            publicationId = args[6].trim();
                            distributorId = args[7].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }

                        if (Orders.addOrders(orderId, deadline, price, orderDate, noOfCopies, shippingCost, publicationId, distributorId).booleanValue()) {
                            System.out.println("Records Updated!!");
                        } else {
                            System.out.println("Updation Failed!!");
                        }
                        return;

                    case 6:
                        System.out.println("Enter String orderId");
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            
                            orderId = args[0].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }
            
                        if (Orders.billDistributorForOrder(orderId)) {
                            System.out.println("Distributor Billed Successfully");
                        } else {
                            System.out.println("Operation Failed");
                        }
                        return;

                    case 7:
                        //Update outstanding balance of a Distributor
                        System.out.println("Enter payment made by distributor(Float) and String orderId for which payment is made separated by |");
                        float payment = 0;
                        System.out.print("-> " + sc.nextLine());
                        try{
                            args = sc.nextLine().split("[|]");
                            System.out.println(Arrays.toString((Object[]) args));
                            
                            
                            payment = Float.valueOf(Float.parseFloat(args[0].trim()));
                            orderId = args[1].trim();
                        }catch(IllegalArgumentException ex){
                            System.out.println("Wrong input format!!! Try again!\n");
                            continue;

                        }
                        if (Distributors.updateDistributorBalance(orderId, payment)) {
                            System.out.println("Distributor balance updated Successfully");
                        } else {
                            System.out.println("Operation Failed");
                        }
                        return;

                    case 8:
                        MainMenu.main(main_args);
                    default:
                        System.out.println("Enter a valid choice");


                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        
        }
    }
}
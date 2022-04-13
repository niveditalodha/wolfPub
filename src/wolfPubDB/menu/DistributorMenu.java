package wolfPubDB.menu;

import java.io.IOException;
import java.util.*;
import java.sql.Date;
import java.io.*;
import wolfPubDB.taskAndOperations.*;


public class DistributorMenu {

    /**
     * a function that connects to the DB distributor menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return distributorMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void distributorMenu() throws NumberFormatException, IOException {
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
                        args = sc.next().split("[|]");
                        System.out.println(Arrays.toString((Object[]) args));
                        distributorId = args[0];
                        name = args[1];
                        type = args[2];
                        balance = Float.valueOf(Float.parseFloat(args[3]));
                        phone = args[4];
                        contactPerson = args[5];
                        street = args[6];
                        city = args[7];


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
                        args = sc.next().split("[|]");
                        System.out.println(Arrays.toString((Object[]) args));
                        distributorId = args[0];
                        name = args[1];
                        type = args[2];
                        balance = Float.valueOf(Float.parseFloat(args[3]));
                        phone = args[4];
                        contactPerson = args[5];
                        street = args[6];
                        city = args[7];

                        if (Distributors.updateDistributors(distributorId, name, type, balance, phone, street, city, contactPerson).booleanValue()) {
                            System.out.println("Records Updated!!");
                        } else {
                            System.out.println("Updation Failed!!");
                        }
                        return;
                    case 4:

                        System.out.println("Enter distributorId");
                        String did = sc.nextLine();
                        if(Distributors.deleteDistributors(did)){
                            System.out.println("Records Updated!!");
                        } else {
                            System.out.println("Updation Failed!!");
                        }
                        return;
                    case 5:
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

                    case 6:
                        System.out.println("Enter String orderId");
                        input = sc.next();
                        orderId = input;
            
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
                        args = sc.next().split("[|]");
                        System.out.println(Arrays.toString((Object[]) args));
                        payment = Float.valueOf(Float.parseFloat(args[0]));
                        orderId = args[1];
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
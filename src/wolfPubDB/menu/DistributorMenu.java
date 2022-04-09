package wolfPubDB.menu;

import java.io.IOException;
import java.util.*;

import java.io.*;
import wolfPubDB.taskAndOperations.*;


public class DistributorMenu {

    public static void distributorMenu() throws NumberFormatException, IOException {
        Float balance;
        String distributorId, name, type, phone,contactPerson,street,city;
        String[] args;
        boolean exit_val = true;
        String[] main_args = null;
        while(exit_val) {
            System.out.println("1. Show all distributors");
            System.out.println("2. Add Distributors");
            System.out.println("3. Update Distributor Details");
            System.out.println("4. Delete Distributor Details");
            System.out.println("5. Back to Main");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Distributors.selectDistributors().forEach(System.out::println);
                    return;
                case 2:
                    System.out.println("Enter String distributorId, String name, String type, Float balance, String phone, String contactPerson, String street, String City separated by comma");
                    args = sc.next().split("[,]");
                    System.out.println(Arrays.toString((Object[]) args));
                    distributorId = args[0];
                    name = args[1];
                    type = args[2];
                    balance = Float.valueOf(Float.parseFloat(args[3]));
                    phone = args[4];
                    contactPerson = args[5];
                    street = args[6];
                    city = args[7];


                    if(Distributors.addDistributor(distributorId, name, type, balance, phone, contactPerson, street, city))
                    {
                        System.out.println("Records Inserted!!");
                    }
                    else
                    {
                        System.out.println("Insertion Failed!!");
                    }
                    return;
                case 3:

                    System.out.println("Enter String distributorId, String name, String type, Float balance, String phone, String contactPerson, String street, String City separated by ,");
                    args = sc.next().split("[,]");
                    System.out.println(Arrays.toString((Object[]) args));
                    distributorId = args[0];
                    name = args[1];
                    type = args[2];
                    balance = Float.valueOf(Float.parseFloat(args[3]));
                    phone = args[4];
                    contactPerson = args[5];
                    street = args[6];
                    city = args[7];

                    if (Distributors.updateDistributors(distributorId, name, type, balance, phone, contactPerson, street, city).booleanValue()) {
                        System.out.println("Records Updated!!");
                    } else {
                        System.out.println("Updation Failed!!");
                    }
                    return;
                case 4:

                    System.out.println("Enter distributorId");
                    String did = sc.nextLine();
                    if(Distributors.deleteDistributor(did)){
                        System.out.println("Records Updated!!");
                    } else {
                        System.out.println("Updation Failed!!");
                    }
                    return;
                case 5:
                    MainMenu.main(main_args);
                default:
                    System.out.println("Enter a valid choice");


            }
        }
    }
}
package wolfPub.menu;

import wolfPub.connection.DbConnection;
import wolfPub.crud.PaymentOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.sql.*;

public class MainMenu{

    public static void main (Strings[] arg){
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the WOLFPUB Database");
            System.out.println("Menu: Please select your option");
            System.out.println("1. ADMIN");
            System.out.println("2. EDITOR");
            System.out.println("3. DISTRIBUTOR");
            System.out.println("4. EXIT");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        AdminMenu.adminMenu();
                        break;
                    case 2:
                        EditorMenu.editorMenu();
                        break;
                    case 3:
                        DistributorMenu.distributorMenu();
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
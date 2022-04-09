package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;
import wolfPubDB.classes.*;

import java.io.Scanner;
import java.io.*;
import java.sql.SQLException;
import java.sql.SQLOutput;


public class PublicationMenu {

    public static void publicationMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        Integer publicationId, edition, staffId, articleId, chapterId;
        String topics, title, pub_no, publicationDate, isbn, type, issueDate, periodicity, text;

        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICTION OPERATIONS Menu !!");
        System.out.println("1. Enter Book information");
        System.out.println("2. Update Book information");
        System.out.println("3. Assign Editors to Publication");
        System.out.println("4. View Publication based on Editor(Staff ID)");
        System.out.println("5. Assign Author to Book");
        System.out.println("6. Assign Author to Article");
        System.out.println("7. Insert Articles");
        System.out.println("8. Update Articles");
        System.out.println("9. Delete Articles");
        System.out.println("10. Insert Chapters");
        System.out.println("11. Update Chapters");
        System.out.println("12. Delete Chapters");
        System.out.println("13. Back to Main");

        int input = sc.nextInt();

        switch(input){
            

    }
}
}

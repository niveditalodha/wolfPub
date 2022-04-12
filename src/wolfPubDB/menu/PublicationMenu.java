package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;

import wolfPubDB.classes.ReportClass;
import java.util.*;
import java.io.*;
import java.sql.SQLException;


public class PublicationMenu {

    public static void publicationMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;

        String staffId, publicationId, topics, title, periodicity;
        
        ReportClass report;
        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICATION OPERATIONS Menu !!");
        System.out.println("1. Enter new Publication");
        System.out.println("2. Update Publication Information");
        System.out.println("3. Book Related");
        System.out.println("4. Chapters Related");
        System.out.println("5. Issue Related");
        System.out.println("6. Articles Related");
        System.out.println("7. Assign Editors to Publication");
        System.out.println("8. View Publication based on Editor");
        System.out.println("9. Back to Main");


        
        int input = sc.nextInt();

        switch(input){

        case 1:
            // Adding new publication information
            System.out.println("String publicationId, String title, String periodicity, String topics");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];

            if(Publication.addPublication(publicationId, title, periodicity, topics)){
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 2:
            // Updating Publication Information
            System.out.println("Enter String publicationId, String title, String periodicity, String topics");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];

            if(Publication.updatePublication(publicationId, title, periodicity, topics)){
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        case 3:
            BookMenu.bookMenu();
            break;
        
        case 4:
            ChaptersMenu.chaptersMenu();
            break;
        
        case 5:
            IssueMenu.issueMenu();
            break;
        
        case 6:
            ArticlesMenu.articleMenu();
            break;

        case 7:
            // Assign Editors to Publication
            System.out.println("Enter String StaffID(EditorID) and String publicationId");
            args = sc.next().split("[|]");
            staffId = args[0];
            publicationId = args[1];

            if (Edits.addEdits(staffId, publicationId)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 8:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            staffId = sc.next();
            report = Edits.selectEditorPublication(staffId);
            ReportClass.printReport(report);
            return;

        
        case 9:
            // Return to Main Menu
                MainMenu.main(main_args);


        default:
            System.out.println("Enter a valid choice");

    }

    System.out.println("Enter a valid choice");

    }
}
}
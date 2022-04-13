package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;

import wolfPubDB.classes.ReportClass;
import java.util.*;
import java.io.*;
import java.sql.SQLException;


public class PublicationMenu {

     /**
     * a function that connects to the DB Publication menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return publicationMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void publicationMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;

        String staffId, publicationId, topics, title, periodicity;
        
        ReportClass report;
        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICATION OPERATIONS Menu !!");
        System.out.println("1. View Publications");
        System.out.println("2. Enter new Publication");
        System.out.println("3. Update Publication Information");
        System.out.println("4. Book Related");
        System.out.println("5. Chapters Related");
        System.out.println("6. Issue Related");
        System.out.println("7. Articles Related");
        System.out.println("8. Assign Editors to Publication");
        System.out.println("9. View Publication based on Editor");
        System.out.println("10. Back to Main");


        
        int input = sc.nextInt();

        switch(input){
        case 1:
            Publication.selectPublication().forEach(System.out::println);
            break;
        case 2:
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


        case 3:
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

        case 4:
            BookMenu.bookMenu();
            break;
        
        case 5:
            ChaptersMenu.chaptersMenu();
            break;
        
        case 6:
            IssueMenu.issueMenu();
            break;
        
        case 7:
            ArticlesMenu.articleMenu();
            break;

        case 8:
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


        case 9:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            staffId = sc.next();
            report = Edits.selectEditorPublication(staffId);
            ReportClass.printReport(report);
            return;

        
        case 10:
            // Return to Main Menu
                MainMenu.main(main_args);


        default:
            System.out.println("Enter a valid choice");

    }

    }
}
}
package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;

import wolfPubDB.classes.ReportClass;
import java.util.*;
import java.io.*;
import java.sql.SQLException;

/**
 * Class responsible for showing menu options for Publication, Book, Chapter, Issue, Articles.
 */

public class PublicationMenu {

    /**
     * Method that prints and handles the Publication Menu operations.
     * It depends on {@link Publication and @Edits} class that have all 
     * the required APIs for generating the results of Publication. 
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

    public static void publicationMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
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
            System.out.print("-> " + sc.nextLine());
            try{
                args = sc.nextLine().split("[|]");
                publicationId = args[0].trim();
                title = args[1].trim();
                periodicity = args[2].trim();
                topics = args[3].trim();
            }
            catch (IllegalArgumentException ex){
                System.out.println("Wrong input format!!! Try again!\n");
                continue;
            }

            if(Publication.addPublication(publicationId, title, periodicity, topics)){
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 3:
            // Updating Publication Information
            System.out.println("Enter String publicationId, String title, String periodicity, String topics");
            System.out.print("-> " + sc.nextLine());
            try{
                args = sc.nextLine().split("[|]");
                publicationId = args[0].trim();
                title = args[1].trim();
                periodicity = args[2].trim();
                topics = args[3].trim();
            }
            catch (IllegalArgumentException ex){
                System.out.println("Wrong input format!!! Try again!\n");
                continue;
            }

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
            System.out.print("-> " + sc.nextLine());
            try{
                args = sc.nextLine().split("[|]");
                staffId = args[0].trim();
                publicationId = args[1].trim();
            }
            catch(IllegalArgumentException ex){
                System.out.println("Wrong input format!!! Try again!\n");
                continue;
            }
            if (Edits.addEdits(staffId, publicationId)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 9:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            System.out.print("-> " + sc.nextLine());
            try{
                args = sc.nextLine().split("[|]");
                staffId = args[0].trim();
            }
            catch(IllegalArgumentException ex){
                System.out.println("Wrong input format!!! Try again!\n");
                continue;
            }

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
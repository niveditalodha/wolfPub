package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
/**
 * Class responsible for showing menu options for Issue of Periodic Publications.
 */

public class IssueMenu {

    /**
     * Method that prints and handles the Issue of Periodic Publication Menu operations.
     * It depends on {@link Issue and @link Publication} class that have all 
     * the required APIs for generating the results of issues. 
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
    public static void issueMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        Date issueDate;
        String  publicationId, topics, title, type, periodicity;
        while (true) {
            System.out.println("Welcome to the ISSUE MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Issue Information");
            System.out.println("2. Enter an Issue");
            System.out.println("3. Update an Issue");
            System.out.println("4. Delete an Issue");
            System.out.println("5. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Issue Table
                    Issue.selectIssue().forEach(System.out::println);
                    break;
                case 2:
                    // Adding new Issue of a publication
                    System.out.println("Enter String publicationId, String title, String periodicity, String topics, Date issueDate, String type separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        title = args[1].trim();
                        periodicity = args[2].trim();
                        topics = args[3].trim();
                        issueDate = Date.valueOf(args[4].trim());
                        type = args[5].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;

                    }
        
                    if (Publication.addPublication(publicationId, title,periodicity, topics, issueDate, type)){
                        System.out.println("Issue Added Successfully");
                    }else {
                        System.out.println("Operation Failed");
                    }
                    return;
                
        
                case 3:
                    // Update Issue
                    System.out.println("Enter String publicationId, Date issueDate YYYY-MM-DD, String type separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        issueDate = Date.valueOf(args[1].trim());
                        type = args[2].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;

                    }
        
                    if(Issue.updateIssue(publicationId, issueDate, type)){
                        System.out.println("Issue Updatesd");
                    }else{
                        System.out.println("Issue Updation Failed");
                    }
        
                    return;
                
                case 4:
                    // Delete Issue
                    System.out.println("Enter String publicationId");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;

                    }
                    if (Issue.deleteIssue(publicationId)) {
                        System.out.println("Issue Deleted Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;        
                case 5:
                    MainMenu.main(args);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
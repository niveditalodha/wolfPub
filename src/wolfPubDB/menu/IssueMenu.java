package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
public class IssueMenu {

    public static void issueMenu() throws NumberFormatException, IOException, SQLException {
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
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    title = args[1];
                    periodicity = args[2];
                    topics = args[3];
                    issueDate = Date.valueOf(args[4]);
                    type = args[5];
        
                    if (Publication.addPublication(publicationId, title,periodicity, topics, issueDate, type)){
                        System.out.println("Issue Added Successfully");
                    }else {
                        System.out.println("Operation Failed");
                    }
                    return;
                
        
                case 3:
                    // Update Issue
                    System.out.println("Enter String publicationId, Date issueDate YYYY-MM-DD, String type separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    issueDate = Date.valueOf(args[1]);
                    type = args[2];
        
                    if(Issue.updateIssue(publicationId, issueDate, type)){
                        System.out.println("Issue Updatesd");
                    }else{
                        System.out.println("Issue Updation Failed");
                    }
        
                    return;
                
                case 4:
                    // Delete Issue
                    System.out.println("Enter String publicationId");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
        
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
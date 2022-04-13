package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
public class ChaptersMenu {

    /**
     * a function that connects to the DB chapter menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return chaptersMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void chaptersMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        
        String  staffId,  chapterId,chapterNumber, chapterTitle, publicationId;

        while (true) {
            System.out.println("Welcome to the CHAPTERS MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Chapters Information");
            System.out.println("2. Insert Chapters");
            System.out.println("3. Update Chapter's Title");
            System.out.println("4. Update Chapter's Author");
            System.out.println("5. Delete Chapters");
            System.out.println("6: Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Chapters Table
                    Chapters.selectChapter().forEach(System.out::println);
                    break;
                case 2:
                    // Adding a Chapter
                    System.out.println("Enter String publicationId, String chapterNumber, String chapterTitle separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    chapterNumber = args[1];
                    chapterTitle = args[2];
        
                    if (Chapters.addChapter(publicationId, chapterNumber, chapterTitle)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }
                    return;
        
        
                case 3:
                    // Updating a Chapter's Title
                    System.out.println("Enter String publicationId, String chapterNumber, String chapterTitle separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    chapterNumber = args[1];
                    chapterTitle = args[2];
                    if (Chapters.updateChaptersTitle(publicationId, chapterNumber, chapterTitle)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }
        
                    return;
        
        
                case 4:
                    // Updating a Chapter's Author
                    System.out.println("Enter String publicationId, String staffID separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    staffId = args[1];
        
                    if (WritesBook.updateWritesBookChapterAuthor(publicationId, staffId)) {
                        System.out.println(" Updated Chapter's Author Successfully");
                    } else {
                        System.out.println(" Operation Failed");
                    }
        
                    return;
        
                    
                case 5:
                    // Deleting a Chapter 
                    System.out.println("Enter String publicationId and String chapterId separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    chapterId = args[1];
        
                    if (Chapters.deleteChapter(publicationId, chapterId)) {
                        System.out.println("Delete Operation Successful");
                    } else {
                        System.out.println("Delete Operation Failed");
                    }
                    return;
        
                case 6:
                    MainMenu.main(args);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
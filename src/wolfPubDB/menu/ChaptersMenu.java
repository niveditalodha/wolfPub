package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;/**
* Class responsible for showing menu options for Chapters.
*/

public class ChaptersMenu {
   /**
    * Method that prints and handles the Chapters Menu operations.
    * It depends on {@link Chapters and @link Book} class that have all 
    * the required APIs for generating the results of chapters. 
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
    public static void chaptersMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
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
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        chapterNumber = args[1].trim();
                        chapterTitle = args[2].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Chapters.addChapter(publicationId, chapterNumber, chapterTitle)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }
                    return;
        
        
                case 3:
                    // Updating a Chapter's Title
                    System.out.println("Enter String publicationId, String chapterNumber, String chapterTitle separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        chapterNumber = args[1].trim();
                        chapterTitle = args[2].trim();
                    }catch(IllegalArgumentException ex)   {
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Chapters.updateChaptersTitle(publicationId, chapterNumber, chapterTitle)) {
                        System.out.println(" Operation Successful");
                    } else {
                        System.out.println(" Operation Failed");
                    }
        
                    return;
        
        
                case 4:
                    // Updating a Chapter's Author
                    System.out.println("Enter String publicationId, String staffID separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        staffId = args[1].trim();
                    }catch(IllegalArgumentException ex)   {
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (WritesBook.updateWritesBookChapterAuthor(publicationId, staffId)) {
                        System.out.println(" Updated Chapter's Author Successfully");
                    } else {
                        System.out.println(" Operation Failed");
                    }
        
                    return;
        
                    
                case 5:
                    // Deleting a Chapter 
                    System.out.println("Enter String publicationId and String chapterId separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        chapterId = args[1].trim();
                    }catch(IllegalArgumentException ex)   {
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
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
package wolfPubDB.menu;
import java.io.IOException;
import java.util.*;

import java.sql.SQLException;

import wolfPubDB.taskAndOperations.*;
/**
* Class responsible for showing menu options for displaying all tables.
*/

public class Display {
   /**
    * Method that prints and handles the display tables Menu operations.
    * It depends on all taskAndOperations/* classes that have all 
    * the required APIs for generating the results of displaying tables. 
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
    public static void DisplayMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException{

        Scanner sc = new Scanner(System.in);
        String[] main_args = null;
        while (true) {
            System.out.println("Welcome to the DISPLAY MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. View Publication Table");
            System.out.println("2. View Book Table");
            System.out.println("3. View Issue Table ");
            System.out.println("4. View Articles Table ");
            System.out.println("5. View Chapters Table ");
            System.out.println("6. View Distributor Table");
            System.out.println("7. View Editor Table");
            System.out.println("8. View Editor Table");
            System.out.println("9. View Edits Table");
            System.out.println("10. View Orders Table");
            System.out.println("11. View Payment Table");
            System.out.println("12. View Staff Table");
            System.out.println("13. View WritesBook Table");
            System.out.println("14. View WritesArticle Table");
            System.out.println("15. Back to Main Menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                // Select publication Table
                    Publication.selectPublication().forEach(System.out::println);
                    break;
                case 2:
                // Selct Book Table
                    Book.selectBook().forEach(System.out::println);
                    break;
                case 3:
                // Select Issue Table
                    Issue.selectIssue().forEach(System.out::println);
                    break;
                case 4:
                // Select Article Table
                    Articles.selectArticles().forEach(System.out::println);
                    break;
                case 5:
                // Select Chapters Table
                    Chapters.selectChapter().forEach(System.out::println);
                    break;
                case 6:
                // Select Distributors Table
                    Distributors.selectDistributors().forEach(System.out::println);
                    break;
                case 7:
                // Select Editor Table
                    Editor.selectEditor().forEach(System.out::println);
                    break;
                case 8:
                // Select Author Table
                    Author.selectAuthor().forEach(System.out::println);
                    break;
                case 9:
                // Select Edits Table
                    Edits.selectEdits().forEach(System.out::println);
                    break;
                case 10:
                // Select Orders Table
                    Orders.selectOrder().forEach(System.out::println);
                    break;
                case 11:
                // Select Paymetn Table
                    Payment.selectPayment().forEach(System.out::println);
                    break;
                case 12:
                // Select Staff Table
                    Staff.selectStaff().forEach(System.out::println);
                    break;
                case 13:
                // Select Writesbook Table
                    WritesBook.selectWritesBook().forEach(System.out::println);
                    break;
                case 14:
                // Select Writesarticle Table
                    WritesArticle.selectWritesArticle().forEach(System.out::println);
                    break;
                case 15:
                    MainMenu.main(main_args);
                default:
                    System.out.println("Enter a valid choice");
            }
    }

}
}

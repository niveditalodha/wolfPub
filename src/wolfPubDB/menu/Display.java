package wolfPubDB.menu;
import java.io.IOException;
import java.util.*;

import java.sql.SQLException;

import wolfPubDB.taskAndOperations.*;


public class Display {
    
     /**
     * a function that connects to the DB display menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return systemMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void DisplayMenu() throws NumberFormatException, IOException, SQLException{

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

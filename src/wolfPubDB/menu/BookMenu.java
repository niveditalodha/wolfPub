package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
public class BookMenu {

     /**
     * a function that connects to the DB Book menu. Scanner takes in user input and and selects a case based off the input recieved. The case will then perform an action such as selecting another menu or table and then prompting the user for more input
     * 
     * @return bookMenu lists all the menu options for admin to choose and links to those individual menus
     * @return caseResults for selected case from the menu each case will return a prompt or results of the query
     * @throws NumberFormatException occurs when inpromper format is given via string or numeric value
     * @throws IOException occurs when IO operations fail in the try catch blocks
     * @throws SQLException occurs when database error and provides information on the error
     */
    public static void bookMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        String edition;
        Date publicationDate, creationDate;
        String  staffId;
        String publicationId, topics, title, isbn, periodicity, name;
        
        while (true) {
            System.out.println("Welcome to the BOOKS MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Book Information");
            System.out.println("2. Enter Book information");
            System.out.println("3. Update Book information");
            System.out.println("4. Find Book by topic");
            System.out.println("5. Find Book by author name");
            System.out.println("6. Find Book by date");
            System.out.println("7. Assign Author to Book");
            System.out.println("8. Delete a Book Edition");
            System.out.println("9. Back to Main Menu");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Book Table
                    Book.selectBook().forEach(System.out::println);
                    break;
                case 2:
                    // Adding Book information
                    System.out.println("Enter String publicationId, String title, String periodicity, String topics, String isbn, Date publicationDate, String edition separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    title = args[1];
                    periodicity = args[2];
                    topics = args[3];
                    isbn = args[4];
                    publicationDate = Date.valueOf(args[5]);
                    edition = args[6];
        
                    if (Publication.addPublication(publicationId, title, periodicity, topics, isbn, publicationDate, edition)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 3:
                    // Update Book information
                    System.out.println("Enter String publicationId, String isbn, Date publicationDate YYYY-MM-DD, String edition separated by |");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
                    isbn = args[1];
                    publicationDate = Date.valueOf(args[2]);
                    edition = args[3];
        
                    if(Book.updateBook(publicationId, isbn, publicationDate, edition)){
                        System.out.println("Book Operation Sucessful");
                    }else{
                        System.out.println("Book Operation Failed");
                    }
        
                    return;
        
                case 4:
                    // Find book by topic
                    System.out.println("Enter String topic");
                    args = sc.next().split("[|]");
                    topics = args[0];
        
                    Book.selectBookByTopic(topics).forEach(System.out::println);
        
                    return;
        
                case 5:
                    // Find book by author name
                    System.out.println("Enter String Author Name");
                    args = sc.next().split("[|]");
                    name = args[0];
        
                    Book.selectBookByAuthor(name).forEach(System.out::println);
        
                    return;
                
                case 6:
                    // Find book by date
                    System.out.println("Enter date (YYYY-MM-DD)");
                    args = sc.next().split("[|]");
                    creationDate = Date.valueOf(args[0]);
        
                    Book.selectBookByDate(creationDate).forEach(System.out::println);
        
                    return;
                
                case 15:
                    // Assign Author to a Book
                    System.out.println("Enter String StaffID and String publicationId");
                    args = sc.next().split("[|]");
                    staffId = args[0];
                    publicationId = args[1];
        
                    if(WritesBook.addWritesBook(staffId, publicationId)){
                        System.out.println("Operation Sucessful");
                    }else{
                        System.out.println("Operation Failed");
                    }
                    return;

                case 8:
                    // Delete Book Edition
                    System.out.println("Enter String publicationId");
                    args = sc.next().split("[|]");
                    publicationId = args[0];
        
                    if (Book.deleteBook(publicationId)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
                
                case 9:
                    MainMenu.main(args);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
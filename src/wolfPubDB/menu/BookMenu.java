package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;

/**
 * Class responsible for showing menu options for Books.
 */

public class BookMenu {
    /**
     * Method that prints and handles the Books Menu operations.
     * It depends on {@link Book and @link WritesBook} class that have all 
     * the required APIs for generating the results of books. 
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
    public static void bookMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
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
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        title = args[1].trim();
                        periodicity = args[2].trim();
                        topics = args[3].trim();
                        isbn = args[4].trim();
                        publicationDate = Date.valueOf(args[5].trim());
                        edition = args[6].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Publication.addPublication(publicationId, title, periodicity, topics, isbn, publicationDate, edition)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 3:
                    // Update Book information
                    System.out.println("Enter String publicationId, String isbn, Date publicationDate YYYY-MM-DD, String edition separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        publicationId = args[0].trim();
                        isbn = args[1].trim();
                        publicationDate = Date.valueOf(args[2].trim());
                        edition = args[3].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if(Book.updateBook(publicationId, isbn, publicationDate, edition)){
                        System.out.println("Book Operation Sucessful");
                    }else{
                        System.out.println("Book Operation Failed");
                    }
        
                    return;
        
                case 4:
                    // Find book by topic
                    System.out.println("Enter String topic");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        topics = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Book.selectBookByTopic(topics).forEach(System.out::println);
        
                    return;
        
                case 5:
                    // Find book by author name
                    System.out.println("Enter String Author Name");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        name = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Book.selectBookByAuthor(name).forEach(System.out::println);
        
                    return;
                
                case 6:
                    // Find book by date
                    System.out.println("Enter date (YYYY-MM-DD)");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        creationDate = Date.valueOf(args[0].trim());
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Book.selectBookByDate(creationDate).forEach(System.out::println);
        
                    return;
                
                case 7:
                    // Assign Author to a Book
                    System.out.println("Enter String StaffID and String publicationId separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                        publicationId = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if(WritesBook.addWritesBook(staffId, publicationId)){
                        System.out.println("Operation Sucessful");
                    }else{
                        System.out.println("Operation Failed");
                    }
                    return;

                case 8:
                    // Delete Book Edition
                    System.out.println("Enter String publicationId");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.next().split("[|]");
                        publicationId = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    
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
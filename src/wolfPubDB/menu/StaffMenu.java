package wolfPubDB.menu;
import wolfPubDB.classes.ReportClass;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;

/**
 * Class responsible for showing menu options for Staff.
 */

public class StaffMenu {

    /**
     * Method that prints and handles the Staff Menu operations.
     * It depends on {@link Staff , @Editor , @link Edits , @link Author , @link Book and @link Articles} class that have 
     * all the required APIs for generating the results of Staff. 
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

    public static void staffMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        String  staffId,name, type;
        ReportClass report;

        while (true) {
            System.out.println("Welcome to the STAFF MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Editors Table");
            System.out.println("2. Display Authors Table");
            System.out.println("3. Display Staff Table");
            System.out.println("4. Add Editor");
            System.out.println("5. Add Author");
            System.out.println("6. View publication based on staffId");
            System.out.println("7. Find book by author name");
            System.out.println("8. Find article by author name");
            System.out.println("9. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Editor Table
                    Editor.selectEditor().forEach(System.out::println);
                    break;
                case 2:
                    // Select Author Table
                    Author.selectAuthor().forEach(System.out::println);
                    break;
                case 3:
                    // Select Staff Table
                    Staff.selectStaff().forEach(System.out::println);
                    break;
                
                case 4:
                    //Add Editor
                    System.out.println("Enter String StaffId, String Staff Name and String Staff type separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                        name = args[1].trim();
                        type = args[2].trim();
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Staff.addEditor(staffId, name, type);
                    break;

                case 5:
                    //Add Author
                    System.out.println("Enter String StaffId, String Staff Name and String Staff type separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                        name = args[1].trim();
                        type = args[2].trim();
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Staff.addAuthor(staffId, name, type);
                    break;


                case 6:
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

                case 7:
                    // Find book by author name
                    System.out.println("Enter String Author Name");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        name = args[0].trim();
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }

                    Book.selectBookByAuthor(name).forEach(System.out::println);

                    return;
                case 8:
                    // Find Article by author name
                    System.out.println("Enter String Author name");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        name = args[0].trim();
                    }   
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Articles.selectArticlesByAuthor(name).forEach(System.out::println);

                    return;

                case 9:
                    MainMenu.main(args);

                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
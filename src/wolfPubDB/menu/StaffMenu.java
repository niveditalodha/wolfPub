package wolfPubDB.menu;
import wolfPubDB.classes.ReportClass;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;

public class StaffMenu {

    public static void staffMenu() throws NumberFormatException, IOException, SQLException {
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
                    args = sc.next().split("[|]");
                    staffId = args[0];
                    name = args[1];
                    type = args[2];
                    Staff.addEditor(staffId, name, type);
                    break;

                case 5:
                    //Add Author
                    System.out.println("Enter String StaffId, String Staff Name and String Staff type separated by |");
                    args = sc.next().split("[|]");
                    staffId = args[0];
                    name = args[1];
                    type = args[2];
                    Staff.addAuthor(staffId, name, type);
                    break;
                case 6:
                    // View Publication based on Editor(Staff ID)
                    System.out.println("Enter the Editor's Staff ID:");
                    staffId = sc.next();
                    report = Edits.selectEditorPublication(staffId);
                    ReportClass.printReport(report);
                    return;
                case 7:
                    // Find book by author name
                    System.out.println("Enter String Author Name");
                    args = sc.next().split("[|]");
                    name = args[0];

                    Book.selectBookByAuthor(name).forEach(System.out::println);

                    return;
                case 8:
                    // Find Article by author name
                    System.out.println("Enter String Author name");
                    args = sc.next().split("[|]");
                    name = args[0];

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
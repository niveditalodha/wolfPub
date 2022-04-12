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
        String  staffId,name;
        ReportClass report;

        while (true) {
            System.out.println("Welcome to the STAFF MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Editors Table");
            System.out.println("2. Display Authors Table");
            System.out.println("3. Display Staff Table");
            System.out.println("4. View publication based on staffId");
            System.out.println("5. Find book by author name");
            System.out.println("6. Find article by author name");
            System.out.println("7. Back to Main Menu");

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
                    // View Publication based on Editor(Staff ID)
                    System.out.println("Enter the Editor's Staff ID:");
                    staffId = sc.next();
                    report = Edits.selectEditorPublication(staffId);
                    ReportClass.printReport(report);
                    return;
                case 5:
                    // Find book by author name
                    System.out.println("Enter String Author Name");
                    args = sc.next().split("[|]");
                    name = args[0];

                    Book.selectBookByAuthor(name).forEach(System.out::println);

                    return;
                case 6:
                    // Find Article by author name
                    System.out.println("Enter String Author name");
                    args = sc.next().split("[|]");
                    name = args[0];

                    Articles.selectArticlesByAuthor(name).forEach(System.out::println);

                    return;
                case 7:
                    MainMenu.main(args);
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
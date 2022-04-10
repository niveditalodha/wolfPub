package wolfPubDB.menu;

import wolfPubDB.taskAndOperations.*;
import wolfPubDB.classes.*;

import java.util.*;
import java.io.*;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Date;


public class PublicationMenu {

    public static void publicationMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] main_args = null;

        String edition;
        Date publicationDate, issueDate, creationDate;
        String  staffId, articleId, chapterId,chapterNumber, chapterTitle;
        String publicationId, topics, title, isbn, type, periodicity, text;

        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICTION OPERATIONS Menu !!");
        System.out.println("1. Enter new Publication");
        System.out.println("2. Update Publication Information");
        System.out.println("3. Enter Book information");
        System.out.println("4. Update Book information");
        System.out.println("5. Delete a Book Edition");
        System.out.println("6. Enter Issue");
        System.out.println("7. Assign Editors to Publication");
        System.out.println("8. View Publication based on Editor(Staff ID)");
        System.out.println("9. Assign Author to Book");
        System.out.println("10. Assign Author to Article");
        System.out.println("11. Insert Articles");
        System.out.println("12. Update Articles");
        System.out.println("13. Delete Articles");
        System.out.println("14. Insert Chapters");
        System.out.println("15. Update Chapters Title");
        System.out.println("16. Delete Chapters");
        System.out.println("17. Back to Main");

        int input = sc.nextInt();

        switch(input){

        case 1:
            // Adding new publication information
            System.out.println("String publicationId, String title, String periodicity, String topics");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];

            if(Publication.addPublication(publicationId, title, periodicity, topics)){
                System.out.println("Opeation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 2:
            // Updating Publication Information
            System.out.println("Enter String publicationId, String title, String periodicity, String topics");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];

            if(Publication.updatePublication(publicationId, title, periodicity, topics)){
                System.out.println("Opeation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        case 3:
            // Adding Book information
            System.out.println("Enter String publicationId, String title, String periodicity, String topics, String isbn, Date publicationDate, String edition");
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


        case 4:
            // Update Book information
            System.out.println("Enter String publicationId, String title, String periodicity, String topics, String isbn, Date publicationDate, String edition");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];
            isbn = args[4];
            publicationDate = Date.valueOf(args[5]);
            edition = args[6];

            if(Book.updateBook(publicationId, isbn, publicationDate, edition)){
                System.out.println("Book Operation Sucessful");
            }else{
                System.out.println("Book Operation Failed");
            }

            return;

        
        case 5:
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

        
        case 6:
            // Adding new Issue of a publication
            System.out.println("Enter String publicationId, Date issueDate, String type");
            args = sc.next().split("[|]");
            publicationId = args[0];
            issueDate = Date.valueOf(args[1]);
            type = args[2];

            if (Issue.addIssue(publicationId, issueDate, type)){
                System.out.println("Operation Successful");
            }else {
                System.out.println("Operation Failed");
            }
            return;

        
        case 7:
            // Assign Editors to Publication
            System.out.println("Enter String StaffID and String publicationId");
            args = sc.next().split("[|]");
            staffId = args[0];
            publicationId = args[1];

            if (Edits.addEdits(staffId, publicationId)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 8:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            staffId = sc.nextLine();
            Edits.selectEditorPublication(staffId).forEach(System.out::println);
            return;


        case 9:
            // Assign Editor to an Book
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


        case 10:
            // Assign Editor to an Article
            System.out.println("Enter String StaffID and String articleId");
            args = sc.next().split("[|]");
            staffId = args[0];
            articleId = args[1];

            if(WritesArticle.addWritesArticle(staffId, articleId)){
                System.out.println("Operation Sucessful");
            }else{
                System.out.println("Operation Failed");
            }
            return;


        case 11:
            // Adding an Article
            System.out.println("Enter String articleId, String title ,Date creationDate, String text, String publicationId");
            args = sc.next().split("[|]");
            articleId = args[0];
            title = args[1];
            creationDate = Date.valueOf(args[2]);
            text = args[3];
            publicationId = args[4];
            if (Articles.addArticle(articleId, title, creationDate, text, publicationId)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 12:
            // Updating Article's Text
            System.out.println("Enter String articleId and String text");
            args = sc.next().split("[|]");
            articleId = args[0];
            text = args[1];
            if (Articles.updateArticleText(articleId, text)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 13:
            // Deleting an Article
            System.out.println("Enter String articleId");
            args = sc.next().split("[|]");
            articleId = args[0];
            
            if (Articles.deleteArticle(articleId)) {
                System.out.println("Delete Operation Successful");
            } else {
                System.out.println("Delete Operation Failed");
            }
            return;


        case 14:
            // Adding a Chapter
            System.out.println("Enter String publicationId, String chapterNumber, String chapterTitle");
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


        case 15:
            // Updating a Chapter's Title
            System.out.println("Enter String publicationId, String chapterNumber, String chapterTitle");
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


        case 16:
            // Deleting a Chapter 
            System.out.println("Enter String publicationId and String chapterId");
            args = sc.next().split("[|]");
            publicationId = args[0];
            chapterId = args[1];

            if (Chapters.deleteChapter(publicationId, chapterId)) {
                System.out.println("Delete Operation Successful");
            } else {
                System.out.println("Delete Operation Failed");
            }
            return;


        case 17:
            // Return to Main Menu
                MainMenu.main(main_args);


        default:
            System.out.println("Enter a valid choice");

    }

    System.out.println("Enter a valid choice");

    }
}
}
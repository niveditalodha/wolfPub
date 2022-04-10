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
        Date publicationDate, issueDate,creationDate;
        String  staffId, articleId, chapterId,chapterNumber, chapterTitle;
        String publicationId, topics, title, pub_no, isbn, type, periodicity, text;

        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICTION OPERATIONS Menu !!");
        System.out.println("1. Enter Book information");
        System.out.println("2. Update Book information");
        System.out.println("3. Assign Editors to Publication");
        System.out.println("4. View Publication based on Editor(Staff ID)");
        System.out.println("5. Assign Author to Book");
        System.out.println("6. Assign Author to Article");
        System.out.println("7. Insert Articles");
        System.out.println("8. Update Articles");
        System.out.println("9. Delete Articles");
        System.out.println("10. Insert Chapters");
        System.out.println("11. Update Chapters Title");
        System.out.println("12. Delete Chapters");
        System.out.println("13. Back to Main");

        int input = sc.nextInt();

        switch(input){
            case 1:
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


        case 2:
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



        case 3:
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


        case 4:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            staffId = sc.nextLine();
            Edits.selectEditorPublication(staffId).forEach(System.out::println);
            return;


        case 5:
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


        case 6:
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


        case 7:
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


        case 8:
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


        case 9:
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


        case 10:
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


        case 11:
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


        case 12:
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


        case 13:
            // Return to Main Menu
                MainMenu.main(main_args);


        default:
            System.out.println("Enter a valid choice");

    }

    System.out.println("Enter a valid choice");

    }
}
}
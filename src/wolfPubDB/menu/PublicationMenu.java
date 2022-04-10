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
        Integer amount;
        Date publicationDate, issueDate, creationDate,paymentDate, paymentClaimedDate;
        String  staffId, articleId, chapterId,chapterNumber, chapterTitle;
        String publicationId, topics, title, isbn, type, periodicity, text, name;

        String[] args;

        while (true) {
        System.out.println("Welcome to the PUBLICTION OPERATIONS Menu !!");
        System.out.println("1. Enter new Publication");
        System.out.println("2. Update Publication Information");
        System.out.println("3. Enter Book information");
        System.out.println("4. Update Book information");
        System.out.println("5. Find Book by topic");
        System.out.println("6. Find Book by author name");
        System.out.println("7. Find Book by date");
        System.out.println("8. Delete a Book Edition");
        System.out.println("9. Enter an Issue");
        System.out.println("10. Update an Issue");
        System.out.println("11. Delete an Issue");
        System.out.println("12. Assign Editors to Publication");
        System.out.println("13. View Publication based on Editor");
        System.out.println("15. Assign Author to Book");
        System.out.println("16. Assign Author to Article");
        System.out.println("17. Insert Articles");
        System.out.println("18. Update Articles Text");
        System.out.println("19. Update Article's author name");
        System.out.println("20. Update Article's title");
        System.out.println("21. Update Article's topic");
        System.out.println("22. Update Article's date");
        System.out.println("23. Find Article by topic");
        System.out.println("24. Find Article by author name");
        System.out.println("25. Find Article by date");
        System.out.println("26. Delete Articles");
        System.out.println("27. Insert Chapters");
        System.out.println("28. Update Chapter's Title");
        System.out.println("29. Update Chapter's Author");
        System.out.println("30. Delete Chapters");
        System.out.println("31. Add Payment");
        System.out.println("32. Find when the payments were claimed by staff");
        System.out.println("33. Back to Main");


        
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
            System.out.println("Enter String publicationId, String isbn, Date publicationDate YYYY-MM-DD, String edition");
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

        case 5:
            // Find book by topic
            System.out.println("Enter String topic");
            args = sc.next().split("[|]");
            topics = args[0];

            Book.selectBookByTopic(topics).forEach(System.out::println);

            return;

        case 6:
            // Find book by author name
            System.out.println("Enter String Author Name");
            args = sc.next().split("[|]");
            name = args[0];

            Book.selectBookByAuthor(name).forEach(System.out::println);

            return;
        
        case 7:
            // Find book by date
            System.out.println("Enter date (YYYY-MM-DD)");
            args = sc.next().split("[|]");
            creationDate = Date.valueOf(args[0]);

            Book.selectBookByDate(creationDate).forEach(System.out::println);

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
            // Adding new Issue of a publication
            System.out.println("Enter String publicationId, String title, String periodicity, String topics, Date issueDate, String type");
            args = sc.next().split("[|]");
            publicationId = args[0];
            title = args[1];
            periodicity = args[2];
            topics = args[3];
            issueDate = Date.valueOf(args[4]);
            type = args[5];

            if (Publication.addPublication(publicationId, title,periodicity, topics, issueDate, type)){
                System.out.println("Issue Added Successfully");
            }else {
                System.out.println("Operation Failed");
            }
            return;
        

        case 10:
            // Update Issue
            System.out.println("Enter String publicationId, Date issueDate YYYY-MM-DD, String type");
            args = sc.next().split("[|]");
            publicationId = args[0];
            issueDate = Date.valueOf(args[1]);
            type = args[2];

            if(Issue.updateIssue(publicationId, issueDate, type)){
                System.out.println("Issue Updatesd");
            }else{
                System.out.println("Issue Updation Failed");
            }

            return;
        
        case 11:
            // Delete Issue
            System.out.println("Enter String publicationId");
            args = sc.next().split("[|]");
            publicationId = args[0];

            if (Issue.deleteIssue(publicationId)) {
                System.out.println("Issue Deleted Successfully");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        case 12:
            // Assign Editors to Publication
            System.out.println("Enter String StaffID(EditorID) and String publicationId");
            args = sc.next().split("[|]");
            staffId = args[0];
            publicationId = args[1];

            if (Edits.addEdits(staffId, publicationId)) {
                System.out.println("Operation Successful");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 13:
            // View Publication based on Editor(Staff ID)
            System.out.println("Enter the Editor's Staff ID:");
            staffId = sc.nextLine();
            Edits.selectEditorPublication(staffId).forEach(System.out::println);
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


        case 16:
            // Assign Author to an Article
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


        case 17:
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

        case 18:
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


        case 19:
            // Updating Article's Author name
            System.out.println("Enter String articleId and String staffId");
            args = sc.next().split("[|]");
            articleId = args[0];
            staffId = args[1];
            if (WritesArticle.updateWritesArticleAuthor(articleId, staffId)) {
                System.out.println("Updated Articles Author name Successfully");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        
        case 20:
            // Updating Article's Title
            System.out.println("Enter String articleId and String Title");
            args = sc.next().split("[|]");
            articleId = args[0];
            title = args[1];
            if (Articles.updateArticleTitle(articleId, title)) {
                System.out.println("Updated Articles Title Successfully");
            } else {
                System.out.println("Operation Failed");
            }
            return;


        case 21:
            // Updating Article's Topic
            System.out.println("Enter String articleId and String Topic");
            args = sc.next().split("[|]");
            articleId = args[0];
            topics = args[1];
            if (Articles.updateArticlesTopic(articleId, topics)) {
                System.out.println("Updated Articles Topic Successfully");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        
        case 22:
            // Updating Article's CreationDate
            System.out.println("Enter String articleId and String CreationDate");
            args = sc.next().split("[|]");
            articleId = args[0];
            creationDate = Date.valueOf(args[1]);
            if (Articles.updateArticleCreationDate(articleId, creationDate)) {
                System.out.println("Updated Articles Creation Date Successfully");
            } else {
                System.out.println("Operation Failed");
            }
            return;

        
        case 23:
            // Find Article by Topic
            System.out.println("Enter String Topic");
            args = sc.next().split("[|]");
            topics = args[0];

            Articles.selectArticlesByTopic(topics).forEach(System.out::println);

            return;


        case 24:
            // Find Article by author name
            System.out.println("Enter String Author name");
            args = sc.next().split("[|]");
            name = args[0];

            Articles.selectArticlesByAuthor(name).forEach(System.out::println);

            return;
        

        case 25:
            // Find Article by CreationDate
            System.out.println("Enter date (YYYY-MM-DD)");
            args = sc.next().split("[|]");
            creationDate = Date.valueOf(args[0]);

            Articles.selectArticlesByDate(creationDate).forEach(System.out::println);

            return;
        


        case 26:
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


        case 27:
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


        case 28:
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


        case 29:
            // Updating a Chapter's Author
            System.out.println("Enter String publicationId, String staffID");
            args = sc.next().split("[|]");
            publicationId = args[0];
            staffId = args[1];

            if (WritesBook.updateWritesBookChapterAuthor(publicationId, staffId)) {
                System.out.println(" Updaed Chapter's Author Successfully");
            } else {
                System.out.println(" Operation Failed");
            }

            return;

            
        case 30:
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


        case 31:
            // Add Payment
            System.out.println("Enter String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate");
            args = sc.next().split("[|]");
            staffId = args[0];
            paymentDate = Date.valueOf(args[1]);
            amount = Integer.valueOf(args[2]);
            paymentClaimedDate = Date.valueOf(args[3]);

            if (Payment.addPayment(staffId, paymentDate, amount, paymentClaimedDate)){
                System.out.println("Addition Successful");
            }
            else{
                System.out.println("Operation Failed");
            }
            return;


        case 32:
            // Find when the payments were claimed by staff
            System.out.println("Enter String staffId");
            args = sc.next().split("[|]");
            staffId = args[0];

            Payment.selectPayment(staffId).forEach(System.out::println);
            return;


        case 33:
            // Return to Main Menu
                MainMenu.main(main_args);


        default:
            System.out.println("Enter a valid choice");

    }

    System.out.println("Enter a valid choice");

    }
}
}
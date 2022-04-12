package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;
public class ArticlesMenu {

    public static void articleMenu() throws NumberFormatException, IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        String[] args = null;
        
        Date creationDate;
        String  staffId, articleId, publicationId, topics, title, text, name;

        while (true) {
            System.out.println("Welcome to the ARTICLES MENU !!");
            System.out.println("Please select your option:");
            System.out.println("1. Display Articles Information");
            System.out.println("2. Insert Articles");
            System.out.println("3. Update Articles Text");
            System.out.println("4. Update Article's author name");
            System.out.println("5. Update Article's title");
            System.out.println("6. Update Article's topic");
            System.out.println("7. Update Article's date");
            System.out.println("8. Find Article by topic");
            System.out.println("9. Find Article by author name");
            System.out.println("10. Find Article by date");
            System.out.println("11. Assign Author to Article");
            System.out.println("12. Delete Articles");
            System.out.println("13. Back to Main Menu");

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    // Select Article Table
                    Articles.selectArticles().forEach(System.out::println);
                    break;
        
        
                case 2:
                    // Adding an Article
                    System.out.println("Enter String articleId, String title ,Date creationDate, String text, String publicationId separated by |");
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
        
                case 3:
                    // Updating Article's Text
                    System.out.println("Enter String articleId and String text separated by |");
                    args = sc.next().split("[|]");
                    articleId = args[0];
                    text = args[1];
                    if (Articles.updateArticleText(articleId, text)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 4:
                    // Updating Article's Author name
                    System.out.println("Enter String articleId and String staffId separated by |");
                    args = sc.next().split("[|]");
                    articleId = args[0];
                    staffId = args[1];
                    if (WritesArticle.updateWritesArticleAuthor(articleId, staffId)) {
                        System.out.println("Updated Articles Author name Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 5:
                    // Updating Article's Title
                    System.out.println("Enter String articleId and String Title separated by |");
                    args = sc.next().split("[|]");
                    articleId = args[0];
                    title = args[1];
                    if (Articles.updateArticleTitle(articleId, title)) {
                        System.out.println("Updated Articles Title Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 6:
                    // Updating Article's Topic
                    System.out.println("Enter String articleId and String Topic separated by |");
                    args = sc.next().split("[|]");
                    articleId = args[0];
                    topics = args[1];
                    if (Articles.updateArticlesTopic(articleId, topics)) {
                        System.out.println("Updated Articles Topic Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 7:
                    // Updating Article's CreationDate
                    System.out.println("Enter String articleId and String CreationDate separated by |");
                    args = sc.next().split("[|]");
                    articleId = args[0];
                    creationDate = Date.valueOf(args[1]);
                    if (Articles.updateArticleCreationDate(articleId, creationDate)) {
                        System.out.println("Updated Articles Creation Date Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 8:
                    // Find Article by Topic
                    System.out.println("Enter String Topic");
                    args = sc.next().split("[|]");
                    topics = args[0];
        
                    Articles.selectArticlesByTopic(topics).forEach(System.out::println);
        
                    return;
        
        
                case 9:
                    // Find Article by author name
                    System.out.println("Enter String Author name");
                    args = sc.next().split("[|]");
                    name = args[0];
        
                    Articles.selectArticlesByAuthor(name).forEach(System.out::println);
        
                    return;
                
        
                case 10:
                    // Find Article by CreationDate
                    System.out.println("Enter date (YYYY-MM-DD)");
                    args = sc.next().split("[|]");
                    creationDate = Date.valueOf(args[0]);
        
                    Articles.selectArticlesByDate(creationDate).forEach(System.out::println);
        
                    return;
                
                
                case 11:
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
        
                case 12:
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
        
        
                
                case 13:
                    MainMenu.main(args);
                    break;
                default:
                    System.out.println("Enter a valid choice");
            }

        }
    }
}
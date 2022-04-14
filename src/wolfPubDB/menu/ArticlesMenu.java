package wolfPubDB.menu;
import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import wolfPubDB.taskAndOperations.*;
import java.sql.Date;

/**
 * Class responsible for showing menu options for Articles.
 */

public class ArticlesMenu {

    /**
     * Method that prints and handles the Articles Menu operations.
     * It depends on {@link Articles and @link WritesArticle} class that have all 
     * the required APIs for generating the results of articles. 
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
    public static void articleMenu() throws NumberFormatException, IOException, SQLException, IllegalArgumentException {
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
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        title = args[1].trim();
                        creationDate = Date.valueOf(args[2].trim());
                        text = args[3].trim();
                        publicationId = args[4].trim();
                    }
                    catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Articles.addArticle(articleId, title, creationDate, text, publicationId)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                case 3:
                    // Updating Article's Text
                    System.out.println("Enter String articleId and String text separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        text = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Articles.updateArticleText(articleId, text)) {
                        System.out.println("Operation Successful");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 4:
                    // Updating Article's Author name
                    System.out.println("Enter String articleId and String staffId separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        staffId = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (WritesArticle.updateWritesArticleAuthor(articleId, staffId)) {
                        System.out.println("Updated Articles Author name Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 5:
                    // Updating Article's Title
                    System.out.println("Enter String articleId and String Title separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        title = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Articles.updateArticleTitle(articleId, title)) {
                        System.out.println("Updated Articles Title Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
        
                case 6:
                    // Updating Article's Topic
                    System.out.println("Enter String articleId and String Topic separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        topics = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Articles.updateArticlesTopic(articleId, topics)) {
                        System.out.println("Updated Articles Topic Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 7:
                    // Updating Article's CreationDate
                    System.out.println("Enter String articleId and String CreationDate separated by |");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                        creationDate = Date.valueOf(args[1].trim());
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if (Articles.updateArticleCreationDate(articleId, creationDate)) {
                        System.out.println("Updated Articles Creation Date Successfully");
                    } else {
                        System.out.println("Operation Failed");
                    }
                    return;
        
                
                case 8:
                    // Find Article by Topic
                    System.out.println("Enter String Topic");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        topics = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    Articles.selectArticlesByTopic(topics).forEach(System.out::println);
        
                    return;
        
        
                case 9:
                    // Find Article by author name
                    System.out.println("Enter String Author name");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        name = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
        
                    Articles.selectArticlesByAuthor(name).forEach(System.out::println);
        
                    return;
                
        
                case 10:
                    // Find Article by CreationDate
                    System.out.println("Enter date (YYYY-MM-DD)");
                    System.out.print("-> " + sc.nextLine());
                    try{
                        args = sc.nextLine().split("[|]");
                        creationDate = Date.valueOf(args[0].trim());
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
        
                    Articles.selectArticlesByDate(creationDate).forEach(System.out::println);
        
                    return;
                
                
                case 11:
                    // Assign Author to an Article
                    System.out.println("Enter String StaffID and String articleId separated by |");
                    try{
                        args = sc.nextLine().split("[|]");
                        staffId = args[0].trim();
                        articleId = args[1].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
                    if(WritesArticle.addWritesArticle(staffId, articleId)){
                        System.out.println("Operation Successful");
                    }else{
                        System.out.println("Operation Failed");
                    }
                    return;
        
                case 12:
                    // Deleting an Article
                    System.out.println("Enter String articleId");
                    try{
                        args = sc.nextLine().split("[|]");
                        articleId = args[0].trim();
                    }catch(IllegalArgumentException ex){
                        System.out.println("Wrong input format!!! Try again!\n");
                        continue;
                    }
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
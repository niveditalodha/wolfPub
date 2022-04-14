package wolfPubDB.classes;

/**
 * Class responsible for managing WritesArticle table
 */
public class WritesArticleClass {

    public String staffId;
    public String articleId;

    /**
    * Constructor for WritesArticleClass that creates the attributes for the table writesArticle
    * @param staffId
    * @param articleId
    * 
    */
    public WritesArticleClass(String staffId, String articleId) {
        this.staffId = staffId;
        this.articleId = articleId;
    }

    /**
     * will return the staffId of a staff member when prompted
     * @returns this.staffId 
     */
    public String getStaffId() { 
        return this.staffId; 
    }

    /**
     * will return the article ID of an article when prompted
     * @returns this.articleId 
     */
    public String getArticleId() { 
        return this.articleId; 
    }

    /**
     * will set the staffId of a staff member to a specified value when prompted
     */
    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }
    /**
     * will set the articleID of an article to a specified value when prompted
     */
    public void setArticleId(String articleId) {  
        this.articleId =  articleId;
    }
    @Override
    /**
     * will return the parameters of writesarticle when prompted
     * @returns this.staffId + "\t\t" +this.articleId 
     */
    public String toString(){
        return this.staffId + "\t\t" +this.articleId;
    }
}
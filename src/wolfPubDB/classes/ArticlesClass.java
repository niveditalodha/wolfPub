
ckage wolfPubDB.classes;

import java.util.Date;

/**
 * Class responsible for managing Articles table
 */
public class ArticlesClass{
    public String articleId;
    public String publicationId;
    public String title;
    public Date creationDate;
    public String text;

    /**
    * Constructor for ArticlesClass that creates the attributes for the table articles
    * @param articleId
    * @param publicationId
    * @param title
    * @param creationDate
    * @param text
    * 
    */
    public ArticlesClass(String articleId, String publicationId, String title, Date creationDate, String text){
        this.articleId = articleId;
        this.publicationId = publicationId;
        this.title = title;
        this.creationDate = creationDate;
        this.text = text;
    }
    /**
     * will return the article id of an article when prompted
     * @returns this.articleId 
     */
    public String getArticleID(){
        return this.articleId;
    }

    /**
     * will return the publication id of an article when prompted
     * @returns this.publication id 
     */
    public String getPublicationId(){
        return this.publicationId;
    }

    /**
     * will return the title an article when prompted
     * @returns this.title 
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * will return the creationDate of an article when prompted
     * @returns this.creationDate 
     */
    public Date getCreationDate(){
        return this.creationDate;
    }

    /**
     * will return the text of an article when prompted
     * @returns this.text 
     */
    public String getText(){
        return this.text;
    }

    /**
     * will set the article id to a specified string for an article when prompted
     * @param articleId 
     */
    public void setArticleID(String articleId){
        this.articleId = articleId;
    }

    /**
     * will set the publication id to a specified value for an article when prompted
     */
    public void setPublicationId(){
        this.publicationId = publicationId;
    }

    /**
     * will set the title to a specified value for an article when prompted
     */
    public void setTitle(){
        this.title = title;
    }

    /**
     * will set the creation date to a specified value for an article when prompted
     */
    public void setCreationDate(){
        this.creationDate = creationDate;
    }

    /**
     * will set the article text to a specified value for an article when prompted 
     */
    public void setText(){
        this.text = text;
    }
    @Override

    /**
     * will return parameters of an article when prompted
     * @returns this.articleId + "\t\t" +this.publicationId+ "\t\t"+this.title + "\t\t\t"+String.valueOf(this.creationDate)+"\t\t"+this.text 
     */
    public String toString(){
        return this.articleId + "\t\t" +this.publicationId+ "\t\t"+this.title + "\t\t\t"+String.valueOf(this.creationDate)+"\t\t"+this.text;
    }
}
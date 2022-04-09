package wolfPubDB.classes;

public class Articles{
    public String articleId;
    public String publicationId;
    public String title;
    public Date creationDate;
    public String text;

    public Articles(String articleId, String publicationId, String title, Date creationDate, String text){
        this.articleId = articleId;
        this.publicationId = publicationId;
        this.title = title;
        this.creationDate = creationDate;
        this.text = text;
    }

    public String getArticleID(){
        return this.articleId;
    }
    public String getPublicationId(){
        return this.publicationId;
    }
    public String getTitle(){
        return this.title;
    }
    public Date getCreationDate(){
        return this.creationDate;
    }
    public String getText(){
        return this.text;
    }
    
    public void setArticleID(String articleId){
        this.articleId = articleId;
    }
    public void setPublicationId(){
        this.publicationId = publicationId;
    }
    public void setTitle(){
        this.title = title;
    }
    public void setCreationDate(){
        this.creationDate = creationDate;
    }
    public void setText(){
        this.text = text;
    }
}
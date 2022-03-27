package wolfPubDB.classes;

public class WritesArticle {

    public String staffId;
    public String articleId;

    public WritesArticle(String staffId, string articleId) {
        this.staffId = staffId;
        this.articleId = articleId;
    }
    public String getStaffId() { 
        return this.staffId; 
    }
    public String getArticleId() { 
        return this.articleId; 
    }

    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }
    public void setArticleId(String articleId) {  
        this.articleId =  articleId;
    }

}
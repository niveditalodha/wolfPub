package wolfPubDB.classes;

public class WritesArticleClass {

    public String staffId;
    public String articleId;

    public WritesArticleClass(String staffId, String articleId) {
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
package wolfPubDB.classes;

import java.util.Date;

public class IssueClass{
    public String publicationId;
    public Date issueDate;
    public String type;

    public IssueClass(String publicationId, Date issueDate, String type){
        this.publicationId = publicationId;
        this.issueDate = issueDate;
        this.type = type;
    }

    public String getPublicationId(){
        return this.publicationId;
    }
    public Date getIssueDate(){
        return this.issueDate;
    }
    public String getType(){
        return this.type;
    }

    public void setPublicationId(){
        this.publicationId = publicationId;
    }
    public void setIssueDate(){
        this.issueDate = issueDate;
    }
    public void setType(){
        this.type = type;
    }
    @Override
    public String toString(){
        return this.publicationId + " "+String.valueOf(this.issueDate)+" "+this.type;
    }
}   
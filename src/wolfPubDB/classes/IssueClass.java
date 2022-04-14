package wolfPubDB.classes;

import java.util.Date;

/**
 * Class responsible for managing Issue table
 */
public class IssueClass{
    public String publicationId;
    public Date issueDate;
    public String type;

    /**
    * Constructor for IssueClass that creates the attributes for the table issue
    * @param publicationId
    * @param issueDate
    * @param type
    * 
    */
    public IssueClass(String publicationId, Date issueDate, String type){
        this.publicationId = publicationId;
        this.issueDate = issueDate;
        this.type = type;
    }

    /**
     * will return the publication id of a publication when prompted
     * @returns this.publication 
     */
    public String getPublicationId(){
        return this.publicationId;
    }

    /**
     * will return the issue date of an issue when prompted
     * @returns this.issueDate 
     */
    public Date getIssueDate(){
        return this.issueDate;
    }

    /**
     * will return the type of a issue when prompted
     * @returns this.type 
     */
    public String getType(){
        return this.type;
    }

    /**
     * will set the publication id of an issue to a certain value when prompted
     */
    public void setPublicationId(){
        this.publicationId = publicationId;
    }

    /**
     * will set the issue date of an issue to a certain value when prompted
     */
    public void setIssueDate(){
        this.issueDate = issueDate;
    }

    /**
     * will set the type of an issue to a certain value when prompted
     */
    public void setType(){
        this.type = type;
    }
    @Override
    /**
     * will return the parameters of an issue when prompted
     * @returns this.publicationId + "\t\t"+String.valueOf(this.issueDate)+"\t"+this.type
     */
    public String toString(){
        return this.publicationId + "\t\t"+String.valueOf(this.issueDate)+"\t"+this.type;
    }
}   
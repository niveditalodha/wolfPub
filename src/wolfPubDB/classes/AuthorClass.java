package wolfPubDB.classes;

/**
 * Class responsible for managing Author table
 */
public class AuthorClass{
    public String staffId;

    /**
    * Constructor for AuthorClass that creates the attributes for the table author
    * @param staffId
    * 
    */
    public AuthorClass(String staffId){
        this.staffId = staffId;
    }

    /**
     * will return the staff id of an author when prompted
     * @returns this.staffId 
     */
    public String getStaffId(){
        return this.staffId;
    }

    /**
     * will set the staff id of an author when prompted
     */
    public void setStaffId(){
        this.staffId = staffId;
    }
    @Override
    /**
     * will return the parameters of an author when prompted as a string
     * @returns this.staffId 
     */
    public String toString(){
        return this.staffId;
    }

}
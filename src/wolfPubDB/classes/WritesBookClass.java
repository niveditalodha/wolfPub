package wolfPubDB.classes;

/**
 * Class responsible for managing WritesBook table
 */
public class WritesBookClass {

    public String staffId;
    public String publicationId;

    /**
    * Constructor for WritesBookClass that creates the attributes for the table writesbooks
    * @param staffId
    * @param publicationId
    * 
    */
    public WritesBookClass(String staffId, String publicationId) {
        this.staffId = staffId;
        this.publicationId = publicationId;
    }

    /**
     * will return the staffId of a staff member when prompted
     * @returns this.staffId 
     */
    public String getStaffId() { 
        return this.staffId; 
    }

    /**
     * will return the publicationId of a publication when prompted
     * @returns this.publicationId 
     */
    public String getPublicationId() { 
        return this.publicationId; 
    }

    /**
     * will set the staffId of a staff member to a specified value when prompted
     */
    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }

    /**
     * will set the publicatinId of a publication to a specified value when prompted
     */
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }
    @Override
    /**
     * will return the parameters of writesbook when prompted
     * @returns this.staffId + "\t\t" +this.publicationId 
     */
    public String toString(){
        return this.staffId + "\t\t" +this.publicationId;
    }

}
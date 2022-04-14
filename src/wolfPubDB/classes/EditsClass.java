package wolfPubDB.classes;

/**
 * Class responsible for managing Edits table
 */
public class EditsClass {

    public String staffId;
    public String publicationId;

    /**
    * Constructor for EditsClass that creates the attributes for the table edits
    * @param staffId
    * @param publicationId
    * 
    */
    public EditsClass(String staffId, String publicationId) {
        this.staffId = staffId;
        this.publicationId = publicationId;
    }

    /**
     * will return the staff id of editor when prompted
     * @returns this.staffId 
     */
    public String getStaffId() { 
        return this.staffId; 
    }

    /**
     * will return the publication id of a publication when prompted
     * @returns this.publication 
     */
    public String getPublicationId() { 
        return this.publicationId; 
    }

    /**
     * will set the staff id of an editor to a certain value when prompted
     */
    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }

    /**
     * will set the publication id of a publication to a certain value when prompted
     */
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }
    @Override
    /**
     * will return the parameters of the edits class when prompted
     * @returns this.staffId + "\t\t" +this.publicationId
     */
    public String toString(){
        return this.staffId + "\t\t" +this.publicationId;
    }
}
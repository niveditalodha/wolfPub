package wolfPubDB.classes;

/**
 * Class responsible for managing Editor table
 */
public class EditorClass{
    public String staffId;

    /**
    * Constructor for EditorClass that creates the attributes for the table editor
    *
    * @param staffId
    * 
    */
    public EditorClass(String staffId){
        this.staffId = staffId;
    }

    /**
     * will return the staff id of an editor when prompted
     * @returns this.staffId 
     */
    public String getStaffId(){
        return this.staffId;
    }

    /**
     * will set the staff id of an editor to a certain value when prompted
     */
    public void setStaffId(){
        this.staffId = staffId;
    }
    @Override
    /**
     * will return the parameters of an editor when prompted
     * @returns this.staffId 
     */
    public String toString(){
        return this.staffId;
    }
}
package wolfPubDB.classes;

/**
 * Class responsible for managing Staff table
 */
public class StaffClass{
    public String staffId;
    public String name;
    public String type;

    /**
    * Constructor for StaffClass that creates the attributes for the table staff
    * @param staffId
    * @param name
    * @param type
    * 
    */
    public StaffClass(String staffId, String name, String type){
        this.staffId = staffId;
        this.name = name;
        this.type = type;
    }

    /**
     * will return the staffId of a staff member when prompted
     * @returns this.staffId 
     */
    public String getStaffId(){
        return this.staffId;
    }

    /**
     * will return the name of a staff member when prompted
     * @returns this.name 
     */
    public String getName(){
        return this.name;
    }

    /**
     * will return the type of a staff member when prompted
     * @returns this.type 
     */
    public String getType(){
        return this.type;
    }
    
    /**
     * will set the staffId of a staff member to a specified value when prompted
     */
    public void setStaffId(){
        this.staffId = staffId;
    }

    /**
     * will set the name of a staff member to a specified value when prompted
     */
    public void setName(){
        this.name = name;
    }

    /**
     * will set the type of a staff member to a specified value when prompted
     */
    public void setType(){
        this.type = type;
    }
    @Override
    /**
     * will return the parameters of a staff member when prompted
     * @returns this.staffId + "\t\t" +this.name+ "\t\t"+this.type
     */
    public String toString(){
        return this.staffId + "\t\t" +this.name+ "\t\t"+this.type;
    }
}
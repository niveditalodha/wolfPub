package wolfPubDB.classes;

public class StaffClass{
    public String staffId;
    public String name;
    public String type;

    public StaffClass(String staffId, String name, String type){
        this.staffId = staffId;
        this.name = name;
        this.type = type;
    }

    public String getStaffId(){
        return this.staffId;
    }
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }

    public void setStaffId(){
        this.staffId = staffId;
    }
    public void setName(){
        this.name = name;
    }
    public void setType(){
        this.type = type;
    }
    @Override
    public String toString(){
        return this.staffId + "\t\t" +this.name+ "\t\t"+this.type;
    }
}
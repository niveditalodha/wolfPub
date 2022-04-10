package wolfPubDB.classes;

public class WritesBookClass {

    public String staffId;
    public String publicationId;

    public WritesBookClass(String staffId, String publicationId) {
        this.staffId = staffId;
        this.publicationId = publicationId;
    }
    public String getStaffId() { 
        return this.staffId; 
    }
    public String getPublicationId() { 
        return this.publicationId; 
    }

    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }
    @Override
    public String toString(){
        return this.staffId + " " +this.publicationId;
    }

}
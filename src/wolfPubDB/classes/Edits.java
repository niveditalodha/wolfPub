package wolfPubDB.classes;

public class Edits {

    public String staffId;
    public String publicationId;

    public Edits(String staffId, string publicationId) {
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

}
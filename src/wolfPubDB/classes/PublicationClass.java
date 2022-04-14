package wolfPubDB.classes;


/**
 * Class responsible for managing Publication table
 */
public class PublicationClass {

    public String publicationId;
    public String title;
    public String periodicity;
    public String topics;

    /**
    * Constructor for PublicationClass that creates the attributes for the table publication
    * @param publicationId
    * @param title
    * @param creationDate
    * @param text
    * 
    */
    public PublicationClass(String publicationId, String title, String periodicity, String topics) {
        this.publicationId = publicationId;
        this.periodicity = periodicity;
        this.topics = topics;
        this.title = title;
    }

    /**
     * will return the publicationId of a publication when prompted
     * @returns this.publicatinId 
     */
    public String getPublicationId() { 
        return this.publicationId; 
    }

    /**
     * will return the title of a publication when prompted
     * @returns this.title 
     */
    public String getTitle() { 
        return this.title; 
    }

    /**
     * will return the periodicity of a publication when prompted
     * @returns this.periodicity 
     */
    public String getPeriodicity() { 
        return this.periodicity; 
    }

    /**
     * will return the topics of a publication when prompted
     * @returns this.topics 
     */
    public String getTopics() { 
        return this.topics; 
    }

    /**
     * will set the publicationId of a publication to a specified value when prompted
     */
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }

    /**
     * will set the title of a publication to a specified value when prompted
     */
    public void setTitle(String title) {  
        this.title = title; 
    }

    /**
     * will set the periodicity of a publication to a specified value when prompted
     */
    public void setPeriodicity(String periodicity) {  
        this.periodicity = periodicity; 
    }

    /**
     * will set the topics of a publication to a specified value when prompted
     */
    public void setTopics(String topics) {  
        this.topics =  topics;
    }
    @Override
    /**
     * will return the parameters of a publication when prompted
     * @returns this.publicationId + "\t\t" +this.title+ "\t\t"+this.periodicity + "\t\t"+this.topics

     */
    public String toString(){
        return this.publicationId + "\t\t" +this.title+ "\t\t"+this.periodicity + "\t\t"+this.topics;
    }
}
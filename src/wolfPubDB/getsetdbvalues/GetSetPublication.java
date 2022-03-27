package wolfPubDB.getsetdbvalues;

public class GetSetPublication {

    public String publicationId;
    public String title;
    public String periodicity;
    public String topics;

    public GetPublication(Integer publicationId, String title, String periodicity, String topics)
    {
        this.PID = PID;
        this.periodicity = periodicity;
        this.topics = topics;
        this.title = title;
    }
    public String getPublicationId() { return this.publicationId; }
    public String getTitle() { return this.title; }
    public String getPeriodicity() { return this.periodicity; }
    public String getTopics() { return this.topics; }

    public void setPublicationId( String publicationId) {  this.publicationId =  publicationId;}
    public void setTitle(String title) {  this.title = title; }
    public void setPeriodicity(String periodicity) {  this.periodicity = periodicity; }
    public void setTopics(String topic) {  this.topics =  topics;}

}
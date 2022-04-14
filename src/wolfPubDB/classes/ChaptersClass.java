package wolfPubDB.classes;

/**
 * Class responsible for managing Chapter table
 */
public class ChaptersClass{
    public String publicationId;
    public String chapterNumber;
    public String chapterTitle;

    /**
    * Constructor for ChaptersClass that creates the attributes for the table chapters
    * @param publicationId
    * @param chapterNumber
    * @param chapterTitle
    * 
    */
    public ChaptersClass(String publicationId, String chapterNumber, String chapterTitle){
        this.publicationId = publicationId;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
    }

    /**
     * will return the publication id of a chapter when prompted
     * @returns this.publicationId 
     */
    public String getPublicationId(){
        return this.publicationId;
    }

    /**
     * will return the chapter number of a chapter when prompted
     * @returns this.chapterNumber 
     */
    public String getChapterNumber(){
        return this.chapterNumber;
    }

    /**
     * will return the chapter title of a chapter when prompted
     * @returns this.chapterTitle 
     */
    public String getChapterTitle(){
        return this.chapterTitle;
    }

    /**
     * will set the publication id of a chapter to a specified value when prompted
     * @returns this.publicationId 
     */
    public void setPublicationId(){
        this.publicationId = publicationId;
    }

    /**
     * will set the chapter number of a chapter to a specified value when prompted
     * @returns this.chapterNumber 
     */
    public void setChapterNumber(){
        this.chapterNumber = chapterNumber;
    }

    /**
     * will set the chapter title of a chapter to a specified value when prompted
     * @returns this.chapterTitle 
     */
    public void setChapterTitle(){
        this.chapterTitle = chapterTitle;
    }
    @Override
    /**
     * will the parameters of a chapter 
     * @returns this.publicationId + "\t\t" +this.chapterNumber+ "\t\t"+this.chapterTitle
     */
    public String toString(){
        return this.publicationId + "\t\t" +this.chapterNumber+ "\t\t"+this.chapterTitle;
    }

}
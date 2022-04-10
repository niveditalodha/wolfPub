package wolfPubDB.classes;

public class ChaptersClass{
    public String publicationId;
    public String chapterNumber;
    public String chapterTitle;

    public ChaptersClass(String publicationId, String chapterNumber, String chapterTitle){
        this.publicationId = publicationId;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
    }

    public String getPublicationId(){
        return this.publicationId;
    }
    public String getChapterNumber(){
        return this.chapterNumber;
    }
    public String getChapterTitle(){
        return this.chapterTitle;
    }

    public void setPublicationId(){
        this.publicationId = publicationId;
    }
    public void setChapterNumber(){
        this.chapterNumber = chapterNumber;
    }
    public void setChapterTitle(){
        this.chapterTitle = chapterTitle;
    }

}
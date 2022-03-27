package wolfPubDB.classes;

public class Chapters{
    public String publicationId;
    public String chapterNumber;
    public String chapterTitle;

    public Chapters(String publicationId, String chapterNumber, String chapterTitle){
        this.publicationId = publicationId;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
    }

    public String getPublicationId(){
        return this.publicationId;
    }
    public getChapterNumber(){
        return this.chapterNumber;
    }
    public getChapterTitle(){
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
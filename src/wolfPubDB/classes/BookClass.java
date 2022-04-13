package wolfPubDB.classes;

import java.util.Date;

public class BookClass{
    public String publicationId;
    public String isbn;
    public Date publicationDate;
    public String edition;

    public BookClass(String publicationId, String isbn, Date publicationDate, String edition){
        this.publicationId = publicationId;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.edition = edition;
    }

    public String getPublicationId(){
        return this.publicationId;
    }
    public String getIsbn(){
        return this.isbn;
    }
    public Date getPublicationDate(){
        return this.publicationDate;
    }
    public String getEdition(){
        return this.edition = edition;
    }

    public void setPublicationId(){
        this.publicationId = publicationId;
    }
    public void setIsbn(){
        this.isbn = isbn;
    }
    public void setPublicationDate(){
        this.publicationDate = publicationDate;
    }
    public void setEdition(){
        this.edition = edition;
    }
    @Override
    public String toString(){
        return this.publicationId+ "\t\t"+this.isbn + "\t"+String.valueOf(this.publicationDate)+"\t"+this.edition;
    }

}
package wolfPubDB.classes;

public class Book{
    public String publicationId;
    public String isbn;
    public Date publicationDate;
    public String edition;

    public Book(String publicationId, String isbn, Date publicationDate, String edition){
        this.publicationId = publicationId;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.edition = edition
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
        this.edition = edition
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


}
package wolfPubDB.classes;

import java.util.Date;

/**
 * Class responsible for managing Book table
 */
public class BookClass{
    public String publicationId;
    public String isbn;
    public Date publicationDate;
    public String edition;


    /**
    * Constructor for BookClass that creates the attributes for the table book
    * @param publicationId
    * @param isbn
    * @param publicationDate
    * @param edition
    * 
    */public BookClass(String publicationId, String isbn, Date publicationDate, String edition){
        this.publicationId = publicationId;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.edition = edition;
    }

    /**
     * will return the publication id of a book when prompted
     * @returns this.publicationId 
     */
    public String getPublicationId(){
        return this.publicationId;
    }

    /**
     * will return the isbn of a book when prompted
     * @returns this.isbn 
     */
    public String getIsbn(){
        return this.isbn;
    }

    /**
     * will return the publication date of a book when prompted
     * @returns this.publicationDate 
     */
    public Date getPublicationDate(){
        return this.publicationDate;
    }

    /**
     * will return the edition of a book when prompted
     * @returns this.edition 
     */
    public String getEdition(){
        return this.edition = edition;
    }

    /**
     * will set the publication id of a book to a specified value when prompted
     */
    public void setPublicationId(){
        this.publicationId = publicationId;
    }

    /**
     * will set the isbn of a book to a specified value when prompted
     */
    public void setIsbn(){
        this.isbn = isbn;
    }

    /**
     * will set the publication date of a book to a specified value when prompted
     */
    public void setPublicationDate(){
        this.publicationDate = publicationDate;
    }

    /**
     * will set the edition of a book to a specified value when prompted
     */
    public void setEdition(){
        this.edition = edition;
    }
    @Override
    /**
     * will return the parameters of a book when prompted
     * 
     * @returns this.publicationId+ "\t\t"+this.isbn + "\t"+String.valueOf(this.publicationDate)+"\t"+this.edition
     */
    public String toString(){
        return this.publicationId+ "\t\t"+this.isbn + "\t"+String.valueOf(this.publicationDate)+"\t"+this.edition;
    }

}
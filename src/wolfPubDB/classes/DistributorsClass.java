package wolfPubDB.classes;

/**
 * Class responsible for managing Distributor table
 */
public class DistributorsClass {

    public String distributorId;
    public String name;
    public String type;
    public Float balance;
    public String phone;
    public String city;
    public String street;
    public String contactPerson;

    /**
    * Constructor for DistributorsClass that creates the attributes for the table distributors
    * @param distributorId
    * @param name
    * @param type
    * @param balance
    * @param phone
    * @param city
    * @param street
    * @param contactPerson
    * 
    */
    public DistributorsClass(String distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson) {
        this.distributorId = distributorId;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.contactPerson = contactPerson;
    }

    /**
     * will return the distributor id of a distributor when prompted
     * @returns this.distributorId 
     */
    public String getDistributorId() { 
        return this.distributorId; 
    }

    /**
     * will return the name of a distributor when prompted
     * @returns this.name 
     */
    public String getName() { 
        return this.name; 
    }

    /**
     * will return the type of a distributor when prompted
     * @returns this.type 
     */
    public String getType() { 
        return this.type; 
    }

    /**
     * will return the balance of a distributor when prompted
     * @returns this.balance 
     */
    public Float getBalance() { 
        return this.balance; 
    }

    /**
     * will return the phone number of a distributor when prompted
     * @returns this.phone 
     */
    public String getPhone() { 
        return this.phone; 
    }

    /**
     * will return the city of a distributor when prompted
     * @returns this.city 
     */
    public String getCity() { 
        return this.city; 
    }

    /**
     * will return the street of a distributor when prompted
     * @returns this.street 
     */
    public String getStreet() { 
        return this.street; 
    }

    /**
     * will return the contact person of a distributor when prompted
     * @returns this.contactPerson 
     */
    public String getContactPerson() { 
        return this.contactPerson; 
    }

    /**
     * will set the distributor Id of a distributor to a certain value when prompted
     */
    public void setDistributorId( String distributorId) {  
        this.distributorId =  distributorId;
    }

    /**
     * will set the name of a distributor to a certain value when prompted
     */
    public void setName(String name) {  
        this.name = name; 
    }

    /**
     * will set the type of a distributor to a certain value when prompted
     */
    public void setType(String type) {  
        this.type = type; 
    }

    /**
     * will set the balance of a distributor to a certain value when prompted
     */
    public void setBalance(Float balance) {  
        this.balance = balance; 
    }

    /**
     * will set the phone number of a distributor to a certain value when prompted
     */
    public void setPhone(String phone) {  
        this.phone =  phone;
    }

    /**
     * will set the city of a distributor to a certain value when prompted
     */
    public void setCity(String city) {  
        this.city =  city;
    }

    /**
     * will set the street of a distributor to a certain value when prompted
     */
    public void setStreet(String street) {  
        this.street =  street;
    }

    /**
     * will set the contact person of a distributor to a certain value when prompted
     */
    public void setContactPerson(String contactPerson) {  
        this.contactPerson =  contactPerson;
    }

    @Override
    /**
     * will return the parameters of a distributor when prompted
     * 
     * @returns this.distributorId + "\t" +this.type+ "\t"+String.valueOf(this.balance) + "\t"+this.phone+"\t"+this.city +"\t"+this.street+"\t"+this.contactPerson
     */
    public String toString(){
        return this.distributorId + "\t\t" +this.name+"\t" +this.type+ "\t"+String.valueOf(this.balance) + "\t"+this.phone+"\t"+this.city +"\t"+this.street+"\t"+this.contactPerson;
    }

}
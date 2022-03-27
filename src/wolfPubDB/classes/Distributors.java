package wolfPubDB.classes;

public class Distributors {

    public String distributorId;
    public String name;
    public String type;
    public Float balance;
    public String phone;
    public String city;
    public String street;
    public String contactPerson;

    public Distributors(Integer distributorId, String name, String type, Float balance, String phone, String city, String street, String contactPerson)
    {
        this.distributorId = distributorId;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.contactPerson = contactPerson;
    }
    public String getDistributorId() { return this.distributorId; }
    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public Float getBalance() { return this.balance; }
    public String getPhone() { return this.phone; }
    public String getCity() { return this.city; }
    public String getStreet() { return this.street; }
    public String getContactPerson() { return this.contactPerson; }

    public void setDistributorId( String distributorId) {  this.distributorId =  distributorId;}
    public void setName(String name) {  this.name = name; }
    public void setType(String type) {  this.type = type; }
    public void setBalance(Float balance) {  this.balance = balance; }
    public void setPhone(String phone) {  this.phone =  phone;}
    public void setCity(String city) {  this.city =  city;}
    public void setStreet(String street) {  this.street =  street;}
    public void setContactPerson(String contactPerson) {  this.contactPerson =  contactPerson;}

}
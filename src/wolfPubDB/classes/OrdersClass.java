package wolfPubDB.classes;

import java.util.Date;

/**
 * Class responsible for managing Orders table
 */
public class OrdersClass {

    public String orderId;
    public Date deadline;
    public Float price;
    public Date orderDate;
    public Integer noOfCopies;
    public Float shippingCost;
    public String publicationId;
    public String distributorId;

    /**
    * Constructor for OrdersClass that creates the attributes for the table orders
    * @param orderId
    * @param deadline
    * @param price
    * @param orderDate
    * @param noOfCopies
    * @param shippingCost
    * @param publicationId
    * @param distributorId
    * 
    */
    public OrdersClass(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) {
        this.orderId = orderId;
        this.deadline = deadline;
        this.price = price;
        this.orderDate = orderDate;
        this.noOfCopies = noOfCopies;
        this.shippingCost = shippingCost;
        this.publicationId = publicationId;
        this.distributorId = distributorId;
    }

    /**
     * will return the order id of an order when prompted
     * @returns this.orderId 
     */
    public String getOrderId() { 
        return this.orderId; 
    }

    /**
     * will return the deadline of an order when prompted
     * @returns this.deadline 
     */
    public Date getDeadline() { 
        return this.deadline; 
    }

    /**
     * will return the price of an order when prompted
     * @returns this.price 
     */
    public Float getPrice() { 
        return this.price; 
    }

    /**
     * will return the order date of an order when prompted
     * @returns this.orderDate 
     */
    public Date getOrderDate() { 
        return this.orderDate; 
    }

    /**
     * will return the noOfCopies of an order when prompted
     * @returns this.noOfCopies 
     */
    public Integer getNoOfCopies() { 
        return this.noOfCopies; 
    }

    /**
     * will return the shipping costs of an order when prompted
     * @returns this.shippingCost 
     */
    public Float getShippingCost() { 
        return this.shippingCost; 
    }

    /**
     * will return the publicationId of an order when prompted
     * @returns this.publicationId 
     */
    public String getPublicationId() { 
        return this.publicationId; 
    }

    /**
     * will return the distributor Id of an order when prompted
     * @returns this.distributorId 
     */
    public String getDistributorId() { 
        return this.distributorId; 
    }

    /**
     * will set the orderId of an order to a specific value when prompted
     */
    public void setOrderId( String orderId) {  
        this.orderId = orderId;
    }

    /**
     * will set the deadline of an order to a specific value when prompted
     */
    public void setDeadline(Date deadline) {  
        this.deadline = deadline; 
    }

    /**
     * will set the price of an order to a specific value when prompted
     */
    public void setPrice(Float price) {  
        this.price = price; 
    }

    /**
     * will set the orderDate of an order to a specific value when prompted
     */
    public void setOrderDate(Date orderDate) {  
        this.orderDate = orderDate; 
    }

    /**
     * will set the number of copies of an order to a specific value when prompted
     */
    public void setNoOfCopies(Integer noOfCopies) {  
        this.noOfCopies =  noOfCopies;
    }

    /**
     * will set the shipping costs of an order to a specific value when prompted
     */
    public void setShippingCost(Float shippingCost) {  
        this.shippingCost =  shippingCost;
    }

    /**
     * will set the publication ID of an order to a specific value when prompted
     */
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }

    /**
     * will set the distributor ID of an order to a specific value when prompted
     */
    public void setDistributorId(String distributorId) {  
        this.distributorId =  distributorId;
    }
    @Override
    /**
     * will return the parameters of an order when prompted
     * 
     * @returns this.orderId + "\t\t" +String.valueOf(this.deadline)+ "\t"+String.valueOf(this.price) + "\t\t"+String.valueOf(this.orderDate)+"\t"+String.valueOf(this.noOfCopies) + "\t\t"+ this.shippingCost + "\t\t"+this.publicationId+"\t\t"+this.distributorId

     */
    public String toString(){
        return this.orderId + "\t\t" +String.valueOf(this.deadline)+ "\t"+String.valueOf(this.price) + "\t\t"+String.valueOf(this.orderDate)+"\t"+String.valueOf(this.noOfCopies) + "\t\t"+ this.shippingCost + "\t\t"+this.publicationId+"\t\t"+this.distributorId;
    }
}
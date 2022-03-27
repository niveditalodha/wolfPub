package wolfPubDB.classes;

public class Orders {

    public String orderId;
    public Date deadline;
    public Float price;
    public Date orderDate;
    public Integer noOfCopies;
    public Float shippingCost;
    public String publicationId;
    public String distributorId;


    public Orders(String orderId, Date deadline, Float price, Date orderDate, Integer noOfCopies, Float shippingCost, String publicationId, String distributorId) {
        this.orderId = orderId;
        this.deadline = deadline;
        this.price = price;
        this.orderDate = orderDate;
        this.noOfCopies = noOfCopies;
        this.shippingCost = shippingCost;
        this.publicationId = publicationId;
        this.distributorId = distributorId;
    }
    public String getOrderId() { 
        return this.orderId; 
    }
    public Date getDeadline() { 
        return this.deadline; 
    }
    public Float getPrice() { 
        return this.price; 
    }
    public Date getOrderDate() { 
        return this.orderDate; 
    }
    public Integer getNoOfCopies() { 
        return this.noOfCopies; 
    }
    public Float getShippingCost() { 
        return this.shippingCost; 
    }
    public String getPublicationId() { 
        return this.publicationId; 
    }
    public String getDistributorId() { 
        return this.distributorId; 
    }

    public void setOrderId( String orderId) {  
        this.orderId = orderId;
    }
    public void setDeadline(Date deadline) {  
        this.deadline = deadline; 
    }
    public void setPrice(Float price) {  
        this.price = price; 
    }
    public void setOrderDate(Date orderDate) {  
        this.orderDate = orderDate; 
    }
    public void setNoOfCopies(Integer noOfCopies) {  
        this.noOfCopies =  noOfCopies;
    }
    public void setShippingCost(Float shippingCost) {  
        this.shippingCost =  shippingCost;
    }
    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }
    public void setDistributorId(String distributorId) {  
        this.distributorId =  distributorId;
    }

}
package wolfPubDB.classes;

public class Payment {

    public String staffId;
    public Date paymentDate;
    public Integer amount;
    public Date paymentClaimedDate;

    public Payment(String staffId, Date paymentDate, Integer periodicity, Date paymentClaimedDate) {
        this.publicationId = publicationId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentClaimedDate = paymentClaimedDate;
    }
    public String getPublicationId() { 
        return this.publicationId; 
    }
    public Date getPaymentDate() { 
        return this.paymentDate; 
    }
    public Integer getAmount() { 
        return this.amount; 
    }
    public Date getPaymentClaimedDate() { 
        return this.paymentClaimedDate; 
    }

    public void setPublicationId(String publicationId) {  
        this.publicationId =  publicationId;
    }
    public void setPaymentDate(Date paymentDate) {  
        this.paymentDate = paymentDate; 
    }
    public void setAmount(Integer amount) {  
        this.amount = amount; 
    }
    public void setPaymentClaimedDate(Date paymentClaimedDate) {  
        this.paymentClaimedDate =  paymentClaimedDate;
    }

}
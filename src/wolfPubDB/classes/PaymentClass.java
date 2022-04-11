package wolfPubDB.classes;

import java.util.Date;

public class PaymentClass {

    public String staffId;
    public Date paymentDate;
    public Integer amount;
    public Date paymentClaimedDate;

    public PaymentClass(String staffId, Date paymentDate, Integer periodicity, Date paymentClaimedDate) {
        this.staffId = staffId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentClaimedDate = paymentClaimedDate;
    }
    public String getStaffId() { 
        return this.staffId; 
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

    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
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
    @Override
    public String toString(){
        return this.staffId + " " +String.valueOf(this.paymentDate)+" "+ String.valueOf(this.amount)+" "+String.valueOf(this.paymentClaimedDate);
    }
}
package wolfPubDB.classes;

import java.util.Date;

/**
 * Class responsible for managing Payment table
 */
public class PaymentClass {

    public String staffId;
    public Date paymentDate;
    public Integer amount;
    public Date paymentClaimedDate;

    /**
    * Constructor for PaymentClass that creates the attributes for the table payment
    * @param staffId
    * @param paymentDate
    * @param amount
    * @param paymentClaimedDate
    * 
    */
    public PaymentClass(String staffId, Date paymentDate, Integer amount, Date paymentClaimedDate) {
        this.staffId = staffId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentClaimedDate = paymentClaimedDate;
    }

    /**
     * will return the staff id of a payment when prompted
     * @returns this.staffId 
     */
    public String getStaffId() { 
        return this.staffId; 
    }

    /**
     * will return the payment date of a payment when prompted
     * @returns this.paymentDate 
     */
    public Date getPaymentDate() { 
        return this.paymentDate; 
    }

    /**
     * will return the amount paid of a payment when prompted
     * @returns this.amount 
     */
    public Integer getAmount() { 
        return this.amount; 
    }

    /**
     * will return the payment claimed date of a payment when prompted
     * @returns this.paymentClaimedDate 
     */
    public Date getPaymentClaimedDate() { 
        return this.paymentClaimedDate; 
    }

    /**
     * will set the staff id of a payment to a specified value when prompted
     * 
     */
    public void setStaffId(String staffId) {  
        this.staffId =  staffId;
    }

    /**
     * will set the payment date of a payment to a specified value when prompted
     * 
     */
    public void setPaymentDate(Date paymentDate) {  
        this.paymentDate = paymentDate; 
    }

    /**
     * will set the amount paid of a payment to a specified value when prompted
     * 
     */
    public void setAmount(Integer amount) {  
        this.amount = amount; 
    }

    /**
     * will set the payment claimed date of a payment to a specified value when prompted
     * 
     */
    public void setPaymentClaimedDate(Date paymentClaimedDate) {  
        this.paymentClaimedDate =  paymentClaimedDate;
    }
    @Override
    /**
     * will return the parameters of a payment when prompted
     * @returns this.staffId + "\t\t" +String.valueOf(this.paymentDate)+"\t"+ String.valueOf(this.amount)+"\t\t"+String.valueOf(this.paymentClaimedDate)

     */
    public String toString(){
        return this.staffId + "\t\t" +String.valueOf(this.paymentDate)+"\t"+ String.valueOf(this.amount)+"\t\t"+String.valueOf(this.paymentClaimedDate);
    }
}
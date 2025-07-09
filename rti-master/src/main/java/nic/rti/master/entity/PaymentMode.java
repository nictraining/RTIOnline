package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "PaymentMode")
public class PaymentMode {

    @Id
    @Column(name = "PayMode", length = 2)
    private String payMode;

    @Column(name = "PayDetails", length = 50)
    private String payDetails;

    public String getPayMode() {
        return payMode;
    }

    public String getPayDetails() {
        return payDetails;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public void setPayDetails(String payDetails) {
        this.payDetails = payDetails;
    }
}

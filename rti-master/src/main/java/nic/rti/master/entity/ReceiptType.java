package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "ReceiptType")
public class ReceiptType {

    @Id
    @Column(name = "RCode", length = 1)
    private String rCode;

    @Column(name = "Rdetails", length = 100)
    private String rDetails;

    public String getrCode() {
        return rCode;
    }

    public String getrDetails() {
        return rDetails;
    }

    public void setrCode(String rCode) {
        this.rCode = rCode;
    }

    public void setrDetails(String rDetails) {
        this.rDetails = rDetails;
    }
}

package nic.rti.master.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "TransactionMode")
public class TransactionMode {

    @Id
    @Column(name = "TrCode",length = 2)
    private String trCode;

    @Column(name = "TrName",length = 20)
    private String trName;

    public String getTrCode() {
        return trCode;
    }

    public String getTrName() {
        return trName;
    }

    public void setTrCode(String trCode) {
        this.trCode = trCode;
    }

    public void setTrName(String trName) {
        this.trName = trName;
    }
}

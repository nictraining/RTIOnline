package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "reasons")
public class ReasonList {

    @Id
    @Column(name = "reason", length = 2)
    private String reason;

    @Column(name = "action_code", length = 2)
    private String actionCode;

    @Column(name = "reason_dtls", length = 150)
    private String reasonDtls;


    public String getReason() {
        return reason;
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getReasonDtls() {
        return reasonDtls;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public void setReasonDtls(String reasonDtls) {
        this.reasonDtls = reasonDtls;
    }
}

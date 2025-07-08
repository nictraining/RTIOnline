package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "AppealReasons")
public class AppealReason {

    @Id
    @Column(name = "Appreason", length = 2)
    private String appReason;

    @Column(name = "Appreason_dtls", length = 100)
    private String appReasonDtls;

    @Column(name = "U_Appreason_dtls", length = 100)
    private String uAppReasonDtls;

    public String getAppReason() {
        return appReason;
    }

    public String getAppReasonDtls() {
        return appReasonDtls;
    }

    public String getuAppReasonDtls() {
        return uAppReasonDtls;
    }

    public void setAppReason(String appReason) {
        this.appReason = appReason;
    }

    public void setAppReasonDtls(String appReasonDtls) {
        this.appReasonDtls = appReasonDtls;
    }

    public void setuAppReasonDtls(String uAppReasonDtls) {
        this.uAppReasonDtls = uAppReasonDtls;
    }

}

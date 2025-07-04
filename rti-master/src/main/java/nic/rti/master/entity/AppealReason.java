package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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


}

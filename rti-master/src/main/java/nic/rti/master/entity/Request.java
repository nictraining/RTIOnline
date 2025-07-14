package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Request")
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_no", nullable = false)
    private String registrationNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "state")
    private String state;

    @Column(name = "letter_no")
    private String letterNo;

    @Column(name = "letter_date")
    private LocalDateTime letterDate;

    @Column(name = "language")
    private String language;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "client_pword")
    private String clientPassword;

    @Column(name = "subject_content", length = 1500)
    private String subjectContent;

    @Column(name = "document_id")
    private String documentId;

    @Column(name = "category")
    private String category;

    @Column(name = "pio_id")
    private Integer pioId;

    @Column(name = "recvd_date", nullable = false)
    private LocalDateTime recvdDate;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "ENACD")
    private String enacd;

    @Column(name = "authority_app")
    private String authorityApp;

    @Column(name = "authority_decision")
    private String authorityDecision;

    @Column(name = "subjudice")
    private String subjudice;

    @Column(name = "ReceiptType", nullable = false)
    private String receiptType;

    @Column(name = "mode_of_transfer")
    private String modeOfTransfer;

    @Column(name = "dispatch_type")
    private String dispatchType;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;

    @Column(name = "complaint_source")
    private Integer complaintSource;

    @Column(name = "org_code", nullable = false)
    private Integer orgCode;

    @Column(name = "citizen")
    private String citizen;

    @Column(name = "BPL")
    private String bpl;

    @Column(name = "BPLCard_No")
    private String bplCardNo;

    @Column(name = "BPLIssue_auth")
    private String bplIssueAuth;

    @Column(name = "BPL_Issue_year")
    private String bplIssueYear;

    @Column(name = "Amount")
    private String amount;

    @Column(name = "payment_mode", nullable = false)
    private String paymentMode;

    @Column(name = "receipt_no")
    private String receiptNo;

    @Column(name = "printout")
    private String printout;

    @Column(name = "Original_org", nullable = false)
    private Integer originalOrg;

    @Column(name = "life")
    private String life;

    @Column(name = "rural")
    private String rural;

    @Column(name = "illiterate")
    private String illiterate;

    @Column(name = "ReferenceNo")
    private String referenceNo;

    @Column(name = "CAPIODetails")
    private String capioDetails;

    @Column(name = "PADetails")
    private String paDetails;

    @Column(name = "Dispatch_date")
    private LocalDateTime dispatchDate;

    @Column(name = "dispatch_status")
    private String dispatchStatus;

    @Column(name = "MainPart")
    private String mainPart;

    @Column(name = "RTIRegnRefNo")
    private String rtiRegnRefNo;

    @Column(name = "Website")
    private String website;

    @Column(name = "website_upd_date")
    private LocalDateTime websiteUpdDate;

    @Column(name = "request_status")
    private String requestStatus;

    @Column(name = "current_action_status")
    private String currentActionStatus;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "educational_degree")
    private String educationalDegree;

    @Column(name = "UserCode")
    private String userCode;

    @Column(name = "IPAddress")
    private String ipAddress;

    @Column(name = "CountryName")
    private String countryName;

    @Column(name = "NodalId")
    private Integer nodalId;

    @Column(name = "trans_id")
    private String transId;

    @Column(name = "districtId")
    private Integer districtId;

    @Column(name = "tehsilId")
    private Integer tehsilId;

    @Column(name = "villageId")
    private Integer villageId;

    @Column(name = "remarks")
    private String remarks;

    @PrePersist
    public void prePersist() {
        if (entryDate == null) {
            entryDate = LocalDateTime.now();
        }
    }
}

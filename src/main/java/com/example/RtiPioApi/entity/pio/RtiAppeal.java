package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rti_appeals") // Corresponds to RTIMIS.appeal
public class RtiAppeal {

    @Id
    @Column(name = "registration_no", unique = true, nullable = false)
    private String registrationNo; // Appeal registration number (e.g., GORAG/A/2024/001)

    @Column(name = "request_no", nullable = false)
    private String requestNo; // Original RTI application registration number (FK to RtiApplication.registration_no)

    @Column(name = "appeal_filing_date", nullable = false)
    private LocalDateTime appealFilingDate; // Corresponds to 'Date of Resort' from FAA.pdf

    @Column(name = "appellant_name", nullable = false)
    private String appellantName;

    @Column(name = "status", nullable = false)
    private String status; // Appeal status (e.g., "Pending", "Under Process", "Disposed")

    @Column(name = "ground_of_appeal", columnDefinition = "TEXT")
    private String groundOfAppeal;

    @Column(name = "prayer_or_relief", columnDefinition = "TEXT")
    private String prayerOrRelief;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;

    @Column(name = "cpio_app") // Corresponds to cpio_app in appeal table, which is PIO code
    private String cpioApp; // PIO code associated with the appeal (whose decision is appealed or assigned PIO)

    @Column(name = "org_code") // Organization code for appeal filtering (from PIO_Dashboard_API_Documentation)
    private String orgCode;


    @Transient
    private String originalPioId; // The PIO ID from the associated RTI Application
    @Transient
    private String originalPioResponseDetails; // Response details from the original RTI application

    public RtiAppeal() {
        this.appealFilingDate = LocalDateTime.now();
        this.status = "Pending"; // Default status for new appeals
    }

    // --- Getters and Setters for all fields ---

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public LocalDateTime getAppealFilingDate() {
        return appealFilingDate;
    }

    public void setAppealFilingDate(LocalDateTime appealFilingDate) {
        this.appealFilingDate = appealFilingDate;
    }

    public String getAppellantName() {
        return appellantName;
    }

    public void setAppellantName(String appellantName) {
        this.appellantName = appellantName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroundOfAppeal() {
        return groundOfAppeal;
    }

    public void setGroundOfAppeal(String groundOfAppeal) {
        this.groundOfAppeal = groundOfAppeal;
    }

    public String getPrayerOrRelief() {
        return prayerOrRelief;
    }

    public void setPrayerOrRelief(String prayerOrRelief) {
        this.prayerOrRelief = prayerOrRelief;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public String getCpioApp() {
        return cpioApp;
    }

    public void setCpioApp(String cpioApp) {
        this.cpioApp = cpioApp;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    // Transient fields (Getters and Setters)
    public String getOriginalPioId() {
        return originalPioId;
    }

    public void setOriginalPioId(String originalPioId) {
        this.originalPioId = originalPioId;
    }

    public String getOriginalPioResponseDetails() {
        return originalPioResponseDetails;
    }

    public void setOriginalPioResponseDetails(String originalPioResponseDetails) {
        this.originalPioResponseDetails = originalPioResponseDetails;
    }
}

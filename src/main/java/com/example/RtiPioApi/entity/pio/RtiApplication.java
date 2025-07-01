package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "rti_applications") // Corresponds to RTIMIS.Request in the documentation
public class RtiApplication {

    @Id
    @Column(name = "registration_no", unique = true, nullable = false)
    private String registrationNo; // E.g., "RTI/2024/001" format from docs

    @Column(name = "applicant_name", nullable = false)
    private String applicantName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "state")
    private String state;

    @Column(name = "district")
    private String district;

    @Column(name = "country")
    private String country;

    @Column(name = "educational_status")
    private String educationalStatus;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "below_poverty_line")
    private Boolean belowPovertyLine;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "concerns_life_or_liberty")
    private Boolean concernsLifeOrLiberty;

    @Column(name = "text_for_rti_request", columnDefinition = "TEXT", nullable = false)
    private String textForRtiRequest;

    @Column(name = "supporting_document_url")
    private String supportingDocumentUrl;

    @Column(name = "public_authority_department", nullable = false)
    private String publicAuthorityDepartment;

    @Column(name = "type_of_receipt")
    private String typeOfReceipt;

    @Column(name = "language")
    private String language;

    @Column(name = "request_status", nullable = false, length = 1) // 'N', 'P', 'H', etc. as per docs
    private String requestStatus;

    @Column(name = "current_action_status", length = 2) // '4C', '4L', '30', '4M', etc. as per docs
    private String currentActionStatus;

    @Column(name = "pio_id")
    private String pioId;

    @Column(name = "recvd_date", nullable = false)
    private LocalDate recvdDate;

    @Column(name = "entry_date") // Entry date, as in the docs
    private LocalDateTime entryDate;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;

    @Column(name = "response_details", columnDefinition = "TEXT")
    private String responseDetails;

    @Column(name = "reply_document_url")
    private String replyDocumentUrl;

    @Column(name = "document_id")
    private String documentId;


    public RtiApplication() {
        this.recvdDate = LocalDate.now();
        this.entryDate = LocalDateTime.now();
        this.requestStatus = "N";
    }

    // --- Getters and Setters for all fields ---

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEducationalStatus() {
        return educationalStatus;
    }

    public void setEducationalStatus(String educationalStatus) {
        this.educationalStatus = educationalStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public Boolean getBelowPovertyLine() {
        return belowPovertyLine;
    }

    public void setBelowPovertyLine(Boolean belowPovertyLine) {
        this.belowPovertyLine = belowPovertyLine;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Boolean getConcernsLifeOrLiberty() {
        return concernsLifeOrLiberty;
    }

    public void setConcernsLifeOrLiberty(Boolean concernsLifeOrLiberty) {
        this.concernsLifeOrLiberty = concernsLifeOrLiberty;
    }

    public String getTextForRtiRequest() {
        return textForRtiRequest;
    }

    public void setTextForRtiRequest(String textForRtiRequest) {
        this.textForRtiRequest = textForRtiRequest;
    }

    public String getSupportingDocumentUrl() {
        return supportingDocumentUrl;
    }

    public void setSupportingDocumentUrl(String supportingDocumentUrl) {
        this.supportingDocumentUrl = supportingDocumentUrl;
    }

    public String getPublicAuthorityDepartment() {
        return publicAuthorityDepartment;
    }

    public void setPublicAuthorityDepartment(String publicAuthorityDepartment) {
        this.publicAuthorityDepartment = publicAuthorityDepartment;
    }

    public String getTypeOfReceipt() {
        return typeOfReceipt;
    }

    public void setTypeOfReceipt(String typeOfReceipt) {
        this.typeOfReceipt = typeOfReceipt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getCurrentActionStatus() {
        return currentActionStatus;
    }

    public void setCurrentActionStatus(String currentActionStatus) {
        this.currentActionStatus = currentActionStatus;
    }

    public String getPioId() {
        return pioId;
    }

    public void setPioId(String pioId) {
        this.pioId = pioId;
    }

    public LocalDate getRecvdDate() {
        return recvdDate;
    }

    public void setRecvdDate(LocalDate recvdDate) {
        this.recvdDate = recvdDate;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDateTime closingDate) {
        this.closingDate = closingDate;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public String getReplyDocumentUrl() {
        return replyDocumentUrl;
    }

    public void setReplyDocumentUrl(String replyDocumentUrl) {
        this.replyDocumentUrl = replyDocumentUrl;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
}

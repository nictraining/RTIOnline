package com.example.RtiPioApi.dto.pio;

import com.example.RtiPioApi.util.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class RtiRequestListDTO {
    private String registrationNumber;
    private String name;
    private String receivedDate; // Formatted as DD/MM/YYYY
    private String entryDate;    // Formatted as DD/MM/YYYY or Zoned Date Time
    private String currentActionStatus;
    private String documentId; // For 'NEW' and 'DOCCALL' requests

    // Fields specific to FORWARDED_DPIO (target completion date, days since received)
    private String targetCompletionDate; // received date + 30 days for FORWARDED_DPIO
    private Long daysSinceReceived;      // Number of days since received for FORWARDED_DPIO

    // Fields specific to REPLY_DPIO
    private String dateOfReply;          // Date of reply (DD/MM/YYYY format) for REPLY_DPIO
    private String replyContent;         // Reply content for REPLY_DPIO / ACK_DPIO
    private String filename;             // Attached filename for REPLY_DPIO

    // Fields specific to ACK_DPIO
    private String dpioName;             // DPIO name for ACK_DPIO
    private String reminderDate;         // Reminder date (DD/MM/YYYY format) for ACK_DPIO

    public RtiRequestListDTO() {}

    public RtiRequestListDTO(String registrationNumber, String name, LocalDate receivedDate, LocalDateTime entryDate, String currentActionStatus, String documentId) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.receivedDate = receivedDate != null ? DateFormatter.format(receivedDate) : null;
        this.entryDate = entryDate != null ? DateFormatter.format(entryDate) : null;
        this.currentActionStatus = currentActionStatus;
        this.documentId = documentId;
    }

    // Getters and Setters for all fields
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getCurrentActionStatus() {
        return currentActionStatus;
    }

    public void setCurrentActionStatus(String currentActionStatus) {
        this.currentActionStatus = currentActionStatus;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTargetCompletionDate() {
        return targetCompletionDate;
    }

    public void setTargetCompletionDate(String targetCompletionDate) {
        this.targetCompletionDate = targetCompletionDate;
    }

    public Long getDaysSinceReceived() {
        return daysSinceReceived;
    }

    public void setDaysSinceReceived(Long daysSinceReceived) {
        this.daysSinceReceived = daysSinceReceived;
    }

    public String getDateOfReply() {
        return dateOfReply;
    }

    public void setDateOfReply(String dateOfReply) {
        this.dateOfReply = dateOfReply;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDpioName() {
        return dpioName;
    }

    public void setDpioName(String dpioName) {
        this.dpioName = dpioName;
    }

    public String getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
    }
}

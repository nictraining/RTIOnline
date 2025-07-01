package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deemed_pio") // Corresponds to RTIMIS.DeemedPIO
public class DeemedPio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_no", nullable = false)
    private String registrationNo;

    @Column(name = "dpio_code", nullable = false)
    private String dpioCode; // FK to DpioDetails (DPIOCode)

    @Column(name = "forward_date")
    private LocalDateTime forwardDate;

    @Column(name = "flag", length = 1) // 'N' for New, 'S' for Sent (forwarded), 'R' for Reply received, as per docs
    private String flag;

    @Column(name = "reply_date")
    private LocalDateTime replyDate;

    @Column(name = "reply_content", columnDefinition = "TEXT")
    private String replyContent;

    @Column(name = "reply_filename")
    private String replyFilename;

    public DeemedPio() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getDpioCode() {
        return dpioCode;
    }

    public void setDpioCode(String dpioCode) {
        this.dpioCode = dpioCode;
    }

    public LocalDateTime getForwardDate() {
        return forwardDate;
    }

    public void setForwardDate(LocalDateTime forwardDate) {
        this.forwardDate = forwardDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public LocalDateTime getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(LocalDateTime replyDate) {
        this.replyDate = replyDate;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyFilename() {
        return replyFilename;
    }

    public void setReplyFilename(String replyFilename) {
        this.replyFilename = replyFilename;
    }
}

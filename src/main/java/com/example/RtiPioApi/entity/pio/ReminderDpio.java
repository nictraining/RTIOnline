package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_dpio") // Corresponds to RTIMIS.reminderDPIO
public class ReminderDpio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_no")
    private String registrationNo; // FK to RtiApplication (registration_no)

    @Column(name = "dpio_id", nullable = false)
    private String dpioId; // Foreign key to DpioDetails (DPIOCode or pio_id if DPIO is also a PIO)

    @Column(name = "pio_id") // The PIO ID who sent the reminder or received the acknowledgment
    private String pioId;

    @Column(name = "reminder_date")
    private LocalDateTime reminderDate;

    @Column(name = "reply", columnDefinition = "TEXT") // Content of reply/acknowledgment from DPIO
    private String reply;

    public ReminderDpio() {}

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

    public String getDpioId() {
        return dpioId;
    }

    public void setDpioId(String dpioId) {
        this.dpioId = dpioId;
    }

    public String getPioId() {
        return pioId;
    }

    public void setPioId(String pioId) {
        this.pioId = pioId;
    }

    public LocalDateTime getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDateTime reminderDate) {
        this.reminderDate = reminderDate;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}

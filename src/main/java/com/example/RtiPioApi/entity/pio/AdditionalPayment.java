package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "additional_payment") // Corresponds to RTIMIS.AdditionalPayment
public class AdditionalPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming an auto-generated primary key for this table
    private Long id;

    @Column(name = "registration_no", nullable = false)
    private String registrationNo; // FK to RtiApplication (registration_no)

    @Column(name = "amount_demanded")
    private Double amountDemanded;

    @Column(name = "amount_received")
    private Double amountReceived;

    @Column(name = "demand_date")
    private LocalDateTime demandDate;

    @Column(name = "received_date")
    private LocalDateTime receivedDate;

    @Column(name = "paid", length = 1) // 'Y' for paid, 'N' for not paid, as per docs
    private String paid;

    public AdditionalPayment() {}

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

    public Double getAmountDemanded() {
        return amountDemanded;
    }

    public void setAmountDemanded(Double amountDemanded) {
        this.amountDemanded = amountDemanded;
    }

    public Double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public LocalDateTime getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(LocalDateTime demandDate) {
        this.demandDate = demandDate;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }
}

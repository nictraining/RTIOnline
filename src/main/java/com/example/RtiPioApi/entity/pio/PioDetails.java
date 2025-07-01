package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;

@Entity
@Table(name = "pio_details") // Corresponds to RTIMIS.PIODetails
public class PioDetails {
    @Id
    @Column(name = "pio_id")
    private String pioId;

    @Column(name = "pio_code")
    private String pioCode;

    @Column(name = "pio_name")
    private String pioName;

    @Column(name = "active_idle", length = 1) // 'Y' for active, 'N' for idle/inactive
    private String activeIdle;

    public PioDetails() {}

    // Getters and Setters
    public String getPioId() {
        return pioId;
    }

    public void setPioId(String pioId) {
        this.pioId = pioId;
    }

    public String getPioCode() {
        return pioCode;
    }

    public void setPioCode(String pioCode) {
        this.pioCode = pioCode;
    }

    public String getPioName() {
        return pioName;
    }

    public void setPioName(String pioName) {
        this.pioName = pioName;
    }

    public String getActiveIdle() {
        return activeIdle;
    }

    public void setActiveIdle(String activeIdle) {
        this.activeIdle = activeIdle;
    }
}

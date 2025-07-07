package nic.rti.master.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbluser", schema = "RTIMIS")
public class PioUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ucode;

    private String username;
    private String password;
    private String role;

    @Column(name = "ActiveIdle")
    private String activeIdle;

    // Getters and setters
    public Integer getUcode() {
        return ucode;
    }

    public void setUcode(Integer ucode) {
        this.ucode = ucode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActiveIdle() {
        return activeIdle;
    }

    public void setActiveIdle(String activeIdle) {
        this.activeIdle = activeIdle;
    }
}




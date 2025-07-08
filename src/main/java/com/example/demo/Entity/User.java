package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbluser", schema = "RTIMIS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ucode;

    private String username;
    private String password;
    private String role;
    @Column(name = "login_active")
    private String loginActive; 

    public String getLoginActive() {
        return loginActive;
    }

    public String getPassword() {
        return password;
    }

    public Long getUcode() {
        return ucode;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
    public void setUcode(Long ucode) {
        this.ucode = ucode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLoginActive(String loginActive) {
        this.loginActive = loginActive;
    }
    


   
}

package com.example.rtionlinepj.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbluser", schema = "RTIMIS")
public class User {

    @Id
    @Column(name = "ucode")
    private Long ucode;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "active_idle")
    private String loginActive;

    // Getters and Setters
    public Long getUcode() { return ucode; }
    public void setUcode(Long ucode) { this.ucode = ucode; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getLoginActive() { return loginActive; }
    public void setLoginActive(String loginActive) { this.loginActive = loginActive; }
}

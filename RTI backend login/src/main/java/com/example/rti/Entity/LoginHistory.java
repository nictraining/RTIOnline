package com.example.rti.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LoginHistory")
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Login_Date_Time", nullable = false)
    private LocalDateTime loginDateTime;

    @Column(name = "IP", length = 50)
    private String ip;

    @Column(name = "Browser", length = 200)
    private String browser;

    @Column(name = "OS", length = 100)
    private String os;

    @Column(name = "PA", length = 200)
    private String pa;

    @Column(name = "UCode", nullable = false)
    private Integer uCode;

    @Column(name = "UserName", length = 100)
    private String userName;

    public LoginHistory() {
        // JPA requires a no-args constructor
    }

    public LoginHistory(Integer id,
                        LocalDateTime loginDateTime,
                        String ip,
                        String browser,
                        String os,
                        String pa,
                        Integer uCode,
                        String userName) {
        this.id = id;
        this.loginDateTime = loginDateTime;
        this.ip = ip;
        this.browser = browser;
        this.os = os;
        this.pa = pa;
        this.uCode = uCode;
        this.userName = userName;
    }

    // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(LocalDateTime loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public Integer getuCode() {
        return uCode;
    }

    public void setuCode(Integer uCode) {
        this.uCode = uCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
package com.example.rti.dto;

public class LoginRequest {
    private String username;
    private String password;
    private String ipAddress;
    private String browser;
    private String system;

    // Getters & Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public String getBrowser() { return browser; }
    public void setBrowser(String browser) { this.browser = browser; }
    public String getSystem() { return system; }
    public void setSystem(String system) { this.system = system; }
}

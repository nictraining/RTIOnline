package com.example.RtiPioApi.dto.common;

public class LoginResponse {
    private String message;
    private String role;
    private String userId;
    private String publicAuthority;
    private String jwtToken;

    public LoginResponse(String message, String role, String userId, String publicAuthority, String jwtToken) {
        this.message = message;
        this.role = role;
        this.userId = userId;
        this.publicAuthority = publicAuthority;
        this.jwtToken = jwtToken;
    }

    public String getMessage() {
        return message;
    }

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

    public String getPublicAuthority() {
        return publicAuthority;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPublicAuthority(String publicAuthority) {
        this.publicAuthority = publicAuthority;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}

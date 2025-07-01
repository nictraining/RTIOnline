
package com.example.RtiPioApi.entity.user;

import jakarta.persistence.*;


@Entity
@Table(name = "users") // Corresponds to RTIMIS.tbluser from Login API documentation
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; // e.g., "PIO", "Admin", "Nodal", "FAA"

    @Column(name = "public_authority")
    private String publicAuthority; // The Public Authority this user (e.g., PIO) belongs to.

    @Column(name = "login_active", length = 1) // 'Y' (Active), 'A' (AlreadyActive), 'C' (ChangePass), 'B' (BlockUser), 'P' (BlockPass), 'I' (InValidUser)
    private String loginActive; // Corresponds to login_active/active_idle from Login API documentation

    public User() {}

    public User(String userId, String username, String password, String role, String publicAuthority, String loginActive) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.publicAuthority = publicAuthority;
        this.loginActive = loginActive;
    }

    // --- Getters and Setters for all fields ---

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPublicAuthority() {
        return publicAuthority;
    }

    public void setPublicAuthority(String publicAuthority) {
        this.publicAuthority = publicAuthority;
    }

    public String getLoginActive() {
        return loginActive;
    }

    public void setLoginActive(String loginActive) {
        this.loginActive = loginActive;
    }
}
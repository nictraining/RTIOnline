package com.example.demo.response;

public class LoginResponse {
private final String username;
private final String login_active;
private final String role;
private final Long ucode;

public LoginResponse(String username, String login_active, String role, Long ucode) {
    this.username = username;
    this.login_active = login_active;
    this.role = role;
    this.ucode = ucode;
}

public String getUsername() {
    return username;
}

public String getLogin_active() {
    return login_active;
}

public String getRole() {
    return role;
}

public Long getUcode() {
    return ucode;
}
}
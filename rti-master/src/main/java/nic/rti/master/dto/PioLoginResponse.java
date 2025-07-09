package nic.rti.master.dto;


public class PioLoginResponse {
    private String username;
    private String login_active;
    private String role;
    private Integer ucode;

    // Constructors
    public PioLoginResponse() {}

    public PioLoginResponse(String username, String login_active, String role, Integer ucode) {
        this.username = username;
        this.login_active = login_active;
        this.role = role;
        this.ucode = ucode;
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin_active() {
        return login_active;
    }

    public void setLogin_active(String login_active) {
        this.login_active = login_active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUcode() {
        return ucode;
    }

    public void setUcode(Integer ucode) {
        this.ucode = ucode;
    }
}

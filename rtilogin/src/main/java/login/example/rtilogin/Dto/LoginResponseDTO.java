package login.example.rtilogin.Dto;

public class LoginResponseDTO {
    private String username;
    private String password;
    private String role;
    private int ucode;
    private String login_active;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String username, String password, String role, int ucode, String login_active) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.ucode = ucode;
        this.login_active = login_active;
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

    public int getUcode() {
        return ucode;
    }

    public void setUcode(int ucode) {
        this.ucode = ucode;
    }

    public String getLogin_active() {
        return login_active;
    }

    public void setLogin_active(String login_active) {
        this.login_active = login_active;
    }

    @Override
    public String toString() {
        return "LoginResponseDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", ucode=" + ucode +
                ", login_active='" + login_active + '\'' +
                '}';
    }
}

package login.example.rtilogin.Dto;

public class Logindto {

    private String username;
    private String password;


    public Logindto(String email, String password) {
        this.username = email;
        this.password = password;

    }
    public Logindto() {

    }

    public String getUsername() {
        return username;
    }

    public void setGetUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logindto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

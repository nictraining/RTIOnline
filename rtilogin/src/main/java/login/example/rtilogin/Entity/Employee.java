package login.example.rtilogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbluser")
public class Employee {
    @Id
    @Column(name="employee_id",length = 255)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int employeeId;

    @Column(name = "ucode")
    private int ucode;

    @Column(name="employee_name",length = 255)
    private String employeename;

    @Column(name="email",length = 255)
    private String email;

    @Column(name="username",length = 255)
    private String username;

    @Column(name="password",length = 255)
    private String password;

    @Column(name = "status", length = 255)   // ✅ NEW COLUMN for status check
    private String status;

    // 👉 Optional: Add role & ucode if you want to store in DB too
    @Column(name = "role", length = 255)
    private String role;


    public Employee(int employeeId, int ucode, String employeename, String email, String username, String password, String status, String role) {
        this.employeeId = employeeId;
        this.ucode = ucode;
        this.employeename = employeename;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public Employee() {

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getUcode() {
        return ucode;
    }

    public void setUcode(int ucode) {
        this.ucode = ucode;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", ucode=" + ucode +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

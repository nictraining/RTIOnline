package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;

@Entity
@Table(schema = "RTIMIS", name = "tbluser")
public class UserList {

    @Column(name = "id")
    private Integer id; //from int to Integer // int can not be null

    @Id
    @Column(name = "username", length = 30)
    private String userName;

    @Column(name="password", length=100)
    private String password; // new password field

    @Column(name = "role", length = 2)
    private String role;

    @Column(name = "active_idle", length = 1)
    private String active_idle;

    @Column(name = "date_created")
    private OffsetDateTime date_created;

    @Column(name = "date_updated")
    private OffsetDateTime date_updated;

    @Column(name = "password_change", length = 1)
    private String password_change;

    @Column(name = "ucode")
    private int ucode;

    @Column(name = "flage")
    private int flage;

    @Column(name = "Last_Visited_Time")
    private OffsetDateTime last_visited_time;

    @Column(name = "Flage_Time")
    private OffsetDateTime flage_time;


    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword(){return password;} // getter for password
    public String getRole() {
        return role;
    }

    public String getActive_idle() {
        return active_idle;
    }

    public OffsetDateTime getDate_created() {
        return date_created;
    }

    public OffsetDateTime getDate_updated() {
        return date_updated;
    }

    public String getPassword_change() {
        return password_change;
    }

    public int getUcode() {
        return ucode;
    }

    public int getFlage() {
        return flage;
    }

    public OffsetDateTime getLast_visited_time() {
        return last_visited_time;
    }

    public OffsetDateTime getFlage_time() {
        return flage_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password){this.password=password;} // setter for password

    public void setRole(String role) {
        this.role = role;
    }

    public void setActive_idle(String active_idle) {
        this.active_idle = active_idle;
    }

    public void setDate_created(OffsetDateTime date_created) {
        this.date_created = date_created;
    }

    public void setDate_updated(OffsetDateTime date_updated) {
        this.date_updated = date_updated;
    }

    public void setPassword_change(String password_change) {
        this.password_change = password_change;
    }

    public void setUcode(int ucode) {
        this.ucode = ucode;
    }

    public void setFlage(int flage) {
        this.flage = flage;
    }

    public void setLast_visited_time(OffsetDateTime last_visited_time) {
        this.last_visited_time = last_visited_time;
    }

    public void setFlage_time(OffsetDateTime flage_time) {
        this.flage_time = flage_time;
    }
}

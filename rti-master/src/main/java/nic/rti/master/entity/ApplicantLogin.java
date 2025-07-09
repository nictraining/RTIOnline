package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(schema = "RTIMIS", name = "NetUser")
public class ApplicantLogin {

    @Id
    @Column(name = "UserCode", length = 12)
    private String userCode;

    @Column(name = "UserName", length = 50)
    private String userName;

    @Column(name = "Name", length = 50)
    private String name;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "address1", length = 50)
    private String address1;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "address3", length = 50)
    private String address3;

    @Column(name = "pincode", length = 10)
    private String pincode;

    @Column(name = "country", length = 10)
    private String country;

    @Column(name = "state", length = 10)
    private String state;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "active_idle", length = 1)
    private String activeIdle;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "CountryName", length = 30)
    private String countryName;

    @Column(name = "StateName", length = 30)
    private String stateName;


    public String getUserCode() {
        return userCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getPincode() {
        return pincode;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getActiveIdle() {
        return activeIdle;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setActiveIdle(String activeIdle) {
        this.activeIdle = activeIdle;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}

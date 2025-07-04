package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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

}

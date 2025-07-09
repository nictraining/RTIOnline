package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "NetUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetNetUser {
    @Id
    @Column(name = "UserCode")
    private String userCode;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "active_idle")
    private String activeIdle;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "CountryName")
    private String countryName;

    @Column(name = "StateName")
    private String stateName;
}

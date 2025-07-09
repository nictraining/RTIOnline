package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "nodaldetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetNodalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nodalcode")
    private Integer nodalCode;

    @Column(name = "mindeptcode")
    private Integer minDeptCode;

    private String name;
    private String sex;
    private String designation;
    private String phoneno;
    private String email;
    private String address1;
    private String address2;
    private String address3;
    private String pincode;
    private String activeidle;

    @Temporal(TemporalType.DATE)
    @Column(name = "datecreated")
    private Date dateCreated;

    @Column(name = "role")
    private String role;

    private String state;

    @Column(name = "mobile_no")
    private String mobileNo;
}
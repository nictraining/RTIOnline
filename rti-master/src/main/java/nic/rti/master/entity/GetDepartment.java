package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ministry")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MinistryDeptCode")
    private Integer ministryDeptCode;

    @Column(name = "MinistryDeptDesc")
    private String ministryDeptDesc;

    @Column(name = "CharCode")
    private String charCode;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "Address3")
    private String address3;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "ActiveIdle")
    private String activeIdle;

    @Column(name = "datecreated")
    private String dateCreated;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "LoginEnabled")
    private String loginEnabled;

    @Column(name = "LoginEnabledDt")
    private String loginEnabledDt;

    @Column(name = "DtPDUpdate")
    private String dtPDUpdate;

    @Column(name = "U_MinistryDeptDesc")
    private String uMinistryDeptDesc;

    @Column(name = "DDOCode")
    private String ddoCode;

    @Column(name = "DTOCode")
    private String dtoCode;

    @Column(name = "STOCode")
    private String stoCode;

    @Column(name = "PDPTCode")
    private String pdptCode;
}
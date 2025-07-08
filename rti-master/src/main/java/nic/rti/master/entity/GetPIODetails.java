package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "piodetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPIODetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piocode")
    private Integer PIOCode;

    @Column(name = "mindeptcode")
    private Integer minDeptCode;

    private String name;
    private String sex;

    @Column(name = "designation")
    private String designation;

    @Column(name = "phoneno")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    private String subject;

    @Column(name = "applcode")
    private Integer applCode;

    private String address1;
    private String address2;
    private String address3;
    private String pincode;

    private Integer pio_id;
    private String nodalPIO;
    private String activeIdle;

    @Temporal(TemporalType.DATE)
    @Column(name = "datecreated")
    private Date dateCreated;
}

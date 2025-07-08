package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Appellate",schema = "RTIMIS")
public class Appellate {
    @Id
    @Column(name="ApplId")
    private Integer applId;

    @Column(name="ApplCode")
    private String applCode;

    @Column(name="ActiveIdle")
    private String activeIdle;

}

package nic.rti.master.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "appeal", schema = "RTIMIS")
public class Appeal {

    @Id
    @Column(name = "registration_no")
    private String registrationNo;

    private String name;

    @Column(name = "recv_date")
    private LocalDate recvdDate;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @Column(name = "\"ApplID\"") // Case-sensitive or quoted column name
    private Integer applId;

    @Column(name = "cpio_app")
    private Integer cpioApp;
}

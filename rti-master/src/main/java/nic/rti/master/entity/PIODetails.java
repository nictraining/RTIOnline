package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="PIODetails",schema = "RTIMIS")
public class PIODetails {
    @Id
    @Column(name="pio_id")
    private String pioId;

    @Column(name="Name")
    private String name;

    @Column(name="ActiveIdle")
    private String activeIdle;
}

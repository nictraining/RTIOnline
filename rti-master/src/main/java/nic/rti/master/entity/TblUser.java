package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbluser")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TblUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String role;
    private String active_idle;
    private String date_created;
    private String date_updated;
    private String password_change;
    private int ucode;
    private int flage;
    @Column(name = "Last_Visited_Time")
    private String lastVisitedTime;

    @Column(name = "Flage_Time")
    private String flageTime;
}
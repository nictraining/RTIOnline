package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="action_history",schema="RTIMIS")
@IdClass(ActionHistoryId.class) // composite key
public class ActionHistory {
    @Id
    @Column(name="registration_no")
    private String registrationNo;

    @Id
    @Column(name="action_srno")
    private Integer actionSrno;

    @Column(name="action_status")
    private String actionStatus;

    @Column(name="do_code")
    private String doCode;
}

package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="app_assessment_details",schema="RTIMIS")
public class AppAssessmentDetails {

    @Id
    @Column(name="registration_no")
    private String registrationNo;
}

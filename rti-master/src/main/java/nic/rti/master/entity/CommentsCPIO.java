package nic.rti.master.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name="commentsCPIO",schema="RTIMIS")
public class CommentsCPIO {

    @Id
    @Column(name="registration_no")
    private String registrationNo;

    @Column(name="flag")
    private String flag;

    @Column(name="comments_date")
    private LocalDate commentsDate;

    @Column(name="comments")
    private String comments;// assuming single comment , multiple hue to modify kr denge
    // tab commposite key banana , har comment ko ek serial no dena ye sb krna pdega


}

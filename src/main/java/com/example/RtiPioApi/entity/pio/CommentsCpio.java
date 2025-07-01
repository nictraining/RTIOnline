package com.example.RtiPioApi.entity.pio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments_cpio") // Corresponds to RTIMIS.commentsCPIO
public class CommentsCpio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_no", nullable = false)
    private String registrationNo;

    @Column(name = "flag", length = 1) // 'S' for sought, 'R' for replied, as per docs
    private String flag;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    public CommentsCpio() {}

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

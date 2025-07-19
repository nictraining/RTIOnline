package nic.rti.master.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_request")  // your database table name
public class RequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    // Add getters and setters (or use Lombok if already in project)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

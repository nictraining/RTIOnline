package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(schema = "RTIMIS", name = "PaymentMode")
public class PaymentMode {

    @Id
    @Column(name = "PayMode", length = 2)
    private String payMode;

    @Column(name = "PayDetails", length = 50)
    private String payDetails;

}

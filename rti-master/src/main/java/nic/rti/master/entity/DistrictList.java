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
@Table(schema = "RTIMIS", name = "Districts")
public class DistrictList {

    @Column(name = "StateCode", length = 2)
    private String stateCode;

    @Id
    @Column(name = "DistrictCode")
    private int districtCode;

    @Column(name = "District", length = 50)
    private String district;

}

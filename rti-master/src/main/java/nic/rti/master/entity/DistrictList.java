package nic.rti.master.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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



    public String getStateCode() {
        return stateCode;
    }

    public int getDistrictCode() {
        return districtCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setDistrictCode(int districtCode) {
        this.districtCode = districtCode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}

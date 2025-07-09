package nic.rti.master.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "RTIMIS", name = "states")
public class GetStateList {

    @Id
    @Column(name = "state_code", length = 2)
    private String stateCode;

    @Column(name = "state_name", length = 30)
    private String stateName;

    @Column(name = "website", length = 200)
    private String website;

    @Column(name = "U_state_name", length = 30)
    private String uStateName;

    // Getters and Setters

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getuStateName() {
        return uStateName;
    }

    public void setuStateName(String uStateName) {
        this.uStateName = uStateName;
    }
}

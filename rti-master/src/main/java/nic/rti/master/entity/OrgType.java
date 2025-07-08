package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "OrgType")
public class OrgType {

    @Id
    @Column(name = "OrgTypeCode", length =1)
    private String orgTypeCode;

    @Column(name = "OrgTypeDesc", length =50)
    private String orgTypeDesc;


    public String getOrgTypeCode() {
        return orgTypeCode;
    }

    public String getOrgTypeDesc() {
        return orgTypeDesc;
    }

    public void setOrgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
    }

    public void setOrgTypeDesc(String orgTypeDesc) {
        this.orgTypeDesc = orgTypeDesc;
    }
}

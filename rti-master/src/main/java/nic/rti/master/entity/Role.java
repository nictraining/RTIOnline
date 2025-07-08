package nic.rti.master.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "tblrole")
public class Role {

    @Id
    @Column(name = "code", length = 2)
    private String code;

    @Column(name = "description", length = 60)
    private String description;

    @Column(name = "active_idle", length = 1)
    private String active_idle;

    @Column(name = "folder", length = 20)
    private String folder;

    @Column(name = "detailtable", length = 20)
    private String detailTable;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getActive_idle() {
        return active_idle;
    }

    public String getFolder() {
        return folder;
    }

    public String getDetailTable() {
        return detailTable;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive_idle(String active_idle) {
        this.active_idle = active_idle;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public void setDetailTable(String detailTable) {
        this.detailTable = detailTable;
    }
}

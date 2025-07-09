package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "Title")
public class Title {

    @Id
    @Column(name = "title_code", length = 1)
    private String titleCode;

    @Column(name = "title_name", length = 10)
    private String titleName;


    public String getTitleCode() {
        return titleCode;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}

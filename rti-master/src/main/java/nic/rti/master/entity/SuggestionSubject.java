package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "RTIMIS", name = "SuggSubject")
public class SuggestionSubject {

    @Id
    @Column(name = "SuggSubCode", length = 1)
    private String suggSubCode;

    @Column(name = "SuggSub", length = 100)
    private String suggSub;

    public String getSuggSubCode() {
        return suggSubCode;
    }

    public String getSuggSub() {
        return suggSub;
    }

    public void setSuggSubCode(String suggSubCode) {
        this.suggSubCode = suggSubCode;
    }

    public void setSuggSub(String suggSub) {
        this.suggSub = suggSub;
    }
}

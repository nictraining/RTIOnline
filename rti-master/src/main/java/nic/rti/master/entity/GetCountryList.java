package nic.rti.master.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "RTIMIS", name = "country")
public class GetCountryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    public GetCountryList() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "GetCountryList{" +
                "countryCode=" + countryCode +
                ", countryName='" + countryName + '\'' +
                '}';
    }

}
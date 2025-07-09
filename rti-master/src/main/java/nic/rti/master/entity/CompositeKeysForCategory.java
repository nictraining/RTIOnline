package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeKeysForCategory implements Serializable{

    @Column(name = "MinistryDeptCode")
    private int ministryDeptCode;

    @Column(name = "CategoryCode", length = 3)
    private String categoryCode;



    public CompositeKeysForCategory(int ministryDeptCode, String categoryCode) {
        this.ministryDeptCode = ministryDeptCode;
        this.categoryCode = categoryCode;
    }

    public CompositeKeysForCategory() {
    }

    public int getMinistryDeptCode() {
        return ministryDeptCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setMinistryDeptCode(int ministryDeptCode) {
        this.ministryDeptCode = ministryDeptCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompositeKeysForCategory that = (CompositeKeysForCategory) o;
        return ministryDeptCode == that.ministryDeptCode && Objects.equals(categoryCode, that.categoryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ministryDeptCode, categoryCode);
    }
}

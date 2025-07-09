package nic.rti.master.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(schema = "RTIMIS", name = "Category")
public class Category {

    @EmbeddedId
    private CompositeKeysForCategory compositeKeysForCategory;

    @Column(name = "Description", length = 100)
    private String description;

    @Column(name = "CategoryAddedDate")
    private LocalDateTime categoryAddedDate;

    public CompositeKeysForCategory getCompositeKeysForCategory() {
        return compositeKeysForCategory;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCategoryAddedDate() {
        return categoryAddedDate;
    }

    public void setCompositeKeysForCategory(CompositeKeysForCategory compositeKeysForCategory) {
        this.compositeKeysForCategory = compositeKeysForCategory;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryAddedDate(LocalDateTime categoryAddedDate) {
        this.categoryAddedDate = categoryAddedDate;
    }
}

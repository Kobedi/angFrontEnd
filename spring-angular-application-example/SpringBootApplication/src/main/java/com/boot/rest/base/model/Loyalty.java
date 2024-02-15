package com.boot.rest.base.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loyalty_table")
public class Loyalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id; // Primary Key

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String fomularImageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFomularImageURL() {
        return fomularImageURL;
    }

    public void setFomularImageURL(String fomularImageURL) {
        this.fomularImageURL = fomularImageURL;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Loyalty{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fomularImageURL='" + fomularImageURL + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

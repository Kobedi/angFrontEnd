package com.boot.rest.base.model;


import jakarta.persistence.*;

@Entity
@Table(name = "society_table")
public class Society {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id; // Primary Key

    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

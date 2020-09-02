package com.qa.paints.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class paints {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String colour;

    @Column
    private int stock;

    public paints() {
    }

    public paints(String name, String colour, int stock) {
        this.name = name;
        this.colour = colour;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

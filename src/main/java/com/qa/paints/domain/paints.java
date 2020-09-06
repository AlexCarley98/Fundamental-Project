package com.qa.paints.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"HibernateLazyInitializer","Handler","schemes"})
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
    @ManyToMany
    @JoinTable(
            name = "paints_schemes",
            joinColumns = @JoinColumn(name="paint_id"),
            inverseJoinColumns = @JoinColumn(name = "scheme_id"))
    Set<schemes> schemesIn;

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

    public Set<schemes> getSchemesIn() {
        return schemesIn;
    }

    public void setSchemesIn(Set<schemes> schemesIn) {
        this.schemesIn = schemesIn;
    }
}

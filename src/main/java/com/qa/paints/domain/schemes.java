package com.qa.paints.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class schemes {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String faction;

    public schemes() {
    }

    public schemes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }
}

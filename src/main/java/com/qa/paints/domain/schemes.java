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

    @ManyToMany(mappedBy = "schemesIn")
    Set<paints> paintsIn;

    public schemes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<paints> getPaintsIn() {
        return paintsIn;
    }

    public void setPaintsIn(Set<paints> paintsIn) {
        this.paintsIn = paintsIn;
    }
}

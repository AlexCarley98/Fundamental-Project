package com.qa.paints.dto;

import java.util.ArrayList;
import java.util.List;

public class schemesDTO {

    private Long id;
    private String name;
    private String faction;
    private List<paintsDTO> paints = new ArrayList<>();

    public schemesDTO() {
    }

    public schemesDTO(String name) {
        super();
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<paintsDTO> getPaints() {
        return paints;
    }

    public void setPaints(List<paintsDTO> paints) {
        this.paints = paints;
    }

}
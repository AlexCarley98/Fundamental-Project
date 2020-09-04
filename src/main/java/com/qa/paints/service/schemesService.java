package com.qa.paints.service;

import com.qa.paints.repo.schemesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class schemesService {
    private final schemesRepository repo;

    @Autowired
    public schemesService(schemesRepository repo) {
        this.repo = repo;
    }

}

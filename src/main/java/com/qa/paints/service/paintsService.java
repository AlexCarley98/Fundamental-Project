package com.qa.paints.service;

import com.qa.paints.domain.paints;
import com.qa.paints.repo.paintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class paintsService {
    private final paintsRepository repo;

    @Autowired
    public paintsService(paintsRepository repo){
        this.repo = repo;
    }
    public List<paints> findAllPaints(){
        return this.repo.findAll();
    }

}

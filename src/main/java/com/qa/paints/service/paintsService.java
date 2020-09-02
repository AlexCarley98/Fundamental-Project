package com.qa.paints.service;

import com.qa.paints.domain.paints;
import com.qa.paints.exceptions.paintNotFoundException;
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

    public paints createPaints(paints paints){
        return this.repo.save(paints);
    }

    public paints findPaintByID(Long id){
        return this.repo.findById(id).orElseThrow(paintNotFoundException::new);
    }

    public paints updatePaints(Long id, paints paints){
        paints update = findPaintByID(id);
        update.setName(paints.getName());
        update.setColour(paints.getColour());
        update.setStock(paints.getStock());
        return this.repo.save(update);
    }

    public Boolean deletePaints(Long id){
        if(!this.repo.existsById(id)){
            throw new paintNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}

package com.qa.paints.service;

import com.qa.paints.domain.schemes;
import com.qa.paints.exceptions.schemeNotFoundException;
import com.qa.paints.repo.schemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class schemesService {
    private final schemesRepository repo;

    @Autowired
    public schemesService(schemesRepository repo) {
        this.repo = repo;
    }
    public List<schemes> findAllSchemes(){
        return this.repo.findAll();
    }

    public schemes createSchemes(schemes schemes){
        return this.repo.save(schemes);
    }

    public schemes findSchemeByID(Long id){
        return this.repo.findById(id).orElseThrow(schemeNotFoundException::new);
    }

    public schemes updateSchemes(Long id, schemes schemes){
        schemes update = findSchemeByID(id);
        update.setName(schemes.getName());
        update.setFaction(schemes.getFaction());
        return this.repo.save(update);
    }

    public Boolean deleteSchemesByID(Long id){
        if(!this.repo.existsById(id)){
            throw new schemeNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}

package com.qa.paints.service;

import com.qa.paints.domain.schemes;
import com.qa.paints.dto.schemesDTO;
import com.qa.paints.exceptions.schemeNotFoundException;
import com.qa.paints.repo.schemesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class schemesService {
    private final schemesRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public schemesService(schemesRepository repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    private schemesDTO mapToDTO(schemes schemes){
        return this.mapper.map(schemes, schemesDTO.class);
    }
    public List<schemesDTO> findAllSchemes(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    public schemesDTO createSchemes(schemes schemes){
        return this.mapToDTO(this.repo.save(schemes));
    }

    public schemesDTO findSchemeByID(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(schemeNotFoundException::new));
    }

    public schemesDTO updateSchemes(Long id, schemes schemes){
        schemes update = this.repo.findById(id).orElseThrow(schemeNotFoundException::new);
        update.setName(schemes.getName());
        update.setFaction(schemes.getFaction());
        return this.mapToDTO(this.repo.save(update));
    }

    public Boolean deleteSchemesByID(Long id){
        if(!this.repo.existsById(id)){
            throw new schemeNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}

package com.qa.paints.service;

import com.qa.paints.domain.paints;
import com.qa.paints.dto.paintsDTO;
import com.qa.paints.exceptions.paintNotFoundException;
import com.qa.paints.repo.paintsRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class paintsService {
    private final paintsRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public paintsService(paintsRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    //public List<paints> findAllPaints(){return this.repo.findAll();}
    private paintsDTO mapToDTO(paints paints){
        return this.mapper.map(paints, paintsDTO.class);
    }

    //public paints createPaints(paints paints){return this.repo.save(paints);}
    public List<paintsDTO> readAllPaints(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //public paints findPaintByID(Long id){return this.repo.findById(id).orElseThrow(paintNotFoundException::new);}
    public paintsDTO createPaints(paints paints){
        return this.mapToDTO(this.repo.save(paints));
    }
    public paintsDTO findPaintByID(Long id){
        return this.mapToDTO(this.repo.findById(id)
            .orElseThrow(paintNotFoundException::new));
    }

    public paintsDTO updatePaints(Long id, paints paints){
        paints update = this.repo.findById(id).orElseThrow(paintNotFoundException::new);
        update.setName(paints.getName());
        update.setColour(paints.getColour());
        update.setStock(paints.getStock());
        return this.mapToDTO(this.repo.save(paints));
    }

    public Boolean deletePaintsByID(Long id){
        if(!this.repo.existsById(id)){
            throw new paintNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}

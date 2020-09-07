package com.qa.paints.rest;

import com.qa.paints.domain.schemes;
import com.qa.paints.dto.schemesDTO;
import com.qa.paints.service.schemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class schemesController {
    private final schemesService schemesService;

    @Autowired
    public schemesController(com.qa.paints.service.schemesService schemesService) {
        this.schemesService = schemesService;
    }

    @GetMapping("/getAllSchemes")
    public ResponseEntity<List<schemesDTO>> getAllSchemes(){
        return ResponseEntity.ok(this.schemesService.findAllSchemes());
    }

    @PostMapping("/createScheme")
    public ResponseEntity<schemesDTO> createScheme(@RequestBody schemes schemes){
        return new ResponseEntity<schemesDTO>(this.schemesService.createSchemes(schemes), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteScheme/{id}")
    public Boolean deleteScheme(@PathVariable Long id){
        return this.schemesService.deleteSchemesByID(id);
    }

    @GetMapping("/getSchemeByID/{id}")
    public ResponseEntity<schemesDTO> getSchemeByID(@PathVariable Long id){
        return ResponseEntity.ok(this.schemesService.findSchemeByID(id));
    }

    @PutMapping("/updateScheme/{id}")
    public ResponseEntity<schemesDTO> updateScheme(@PathVariable Long id, @RequestBody schemes schemes){
        return ResponseEntity.ok(this.schemesService.updateSchemes(id, schemes));
    }
}

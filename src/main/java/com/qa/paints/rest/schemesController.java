package com.qa.paints.rest;

import com.qa.paints.domain.schemes;
import com.qa.paints.service.schemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class schemesController {
    private final schemesService schemesService;

    @Autowired
    public schemesController(com.qa.paints.service.schemesService schemesService) {
        this.schemesService = schemesService;
    }

    @GetMapping("/getAllSchemes")
    public List<schemes> getAllSchemes(){
        return this.schemesService.findAllSchemes();
    }

    @PostMapping("/createScheme")
    public schemes createScheme(@RequestBody schemes schemes){
        return this.schemesService.createSchemes(schemes);
    }

    @DeleteMapping("/deleteScheme/{id}")
    public Boolean deleteScheme(@PathVariable Long id){
        return this.schemesService.deleteSchemesByID(id);
    }

    @GetMapping("/getSchemeByID/{id}")
    public schemes getSchemeByID(@PathVariable Long id){
        return this.schemesService.findSchemeByID(id);
    }

    @PutMapping("/updateScheme/{id}")
    public schemes updateScheme(@PathVariable Long id, @RequestBody schemes schemes){
        return this.schemesService.updateSchemes(id, schemes);
    }
    @PutMapping("/updateSchemeWithParam")
    public schemes updateSchemeWithParam(@PathParam("id") Long id, @RequestBody schemes schemes){
        //Pass value with ?id=x
        return this.schemesService.updateSchemes(id, schemes);
    }

}

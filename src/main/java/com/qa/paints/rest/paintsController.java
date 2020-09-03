package com.qa.paints.rest;

import com.qa.paints.domain.paints;
import com.qa.paints.service.paintsService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class paintsController {
    private final paintsService paintsService;

    @Autowired
    public paintsController(com.qa.paints.service.paintsService paintsService) {
        this.paintsService = paintsService;
    }

    @GetMapping("/")
    public List<paints> getAllPaints(){
        return this.paintsService.findAllPaints();
    }

    @PostMapping("/createPaint")
    public paints createPaint(@RequestBody paints paints){
        return this.paintsService.createPaints(paints);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deletePaint(@PathVariable Long id){
        return this.paintsService.deletePaintsByID(id);
    }

    @GetMapping("/getPaintByID/{id}")
    public paints getPaintByID(@PathVariable Long id){
        return this.paintsService.findPaintByID(id);
    }

    @PutMapping("/updatePaint/{id}")
    public paints updatePaint(@PathVariable Long id, @RequestBody paints paints){
        return this.paintsService.updatePaints(id, paints);
    }
    @PutMapping("/updatePaintWithParam")
    public paints updatePaintWithParam(@PathParam("id") Long id, @RequestBody paints paints){
        //Pass value with ?id=x
        return this.paintsService.updatePaints(id, paints);
    }

}

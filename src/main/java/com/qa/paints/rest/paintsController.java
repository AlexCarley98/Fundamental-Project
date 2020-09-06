package com.qa.paints.rest;

import com.qa.paints.domain.paints;
import com.qa.paints.dto.paintsDTO;
import com.qa.paints.service.paintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<paintsDTO>> getAllPaints(){
        return ResponseEntity.ok(this.paintsService.readAllPaints());
    }

    @PostMapping("/createPaint")
    public ResponseEntity<paintsDTO> createPaint(@RequestBody paints paints){
        return new ResponseEntity<paintsDTO>(this.paintsService.createPaints(paints), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePaints(@PathVariable Long id){
        return this.paintsService.deletePaintsByID(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getPaintByID/{id}")
    public ResponseEntity<paintsDTO> getPaintsById(@PathVariable Long id){
        return ResponseEntity.ok(this.paintsService.findPaintByID(id));
    }

    @PutMapping("/updatePaint/{id}")
    public ResponseEntity<paintsDTO> updatePaints(@PathVariable Long id, @RequestBody paints paints){
        return ResponseEntity.ok(this.paintsService.updatePaints(id, paints));
    }
    @PutMapping("/updatePaintWithParam")
    public ResponseEntity<paintsDTO> updatePaintWithParam(@PathParam("id") Long id, @RequestBody paints paints){
        //Pass value with ?id=x
        return ResponseEntity.ok(this.paintsService.updatePaints(id, paints));
    }

}

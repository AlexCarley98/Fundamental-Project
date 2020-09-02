package com.qa.paints.rest;

import com.qa.paints.domain.paints;
import com.qa.paints.service.paintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class paintsController {
    private final paintsService paintsService;

    @Autowired
    public paintsController(com.qa.paints.service.paintsService paintsService) {
        this.paintsService = paintsService;
    }

    @GetMapping("/")
    public List<paints> getAllpaints(){
        return this.paintsService.findAllPaints();
    }

}

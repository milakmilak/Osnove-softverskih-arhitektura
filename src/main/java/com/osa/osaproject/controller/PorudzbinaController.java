package com.osa.osaproject.controller;

import com.osa.osaproject.model.Porudzbina;
import com.osa.osaproject.service.PorudzbinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/porudzbine")
public class PorudzbinaController {

    private static Logger logger = LoggerFactory.getLogger(PorudzbinaController.class);

    private final PorudzbinaService service;

    public PorudzbinaController(PorudzbinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Porudzbina> create(@RequestBody Porudzbina create) {
        logger.info("POST '/api/v1/porudzbine': Creating order.");

        return ResponseEntity.ok(service.create(create));
    }
}

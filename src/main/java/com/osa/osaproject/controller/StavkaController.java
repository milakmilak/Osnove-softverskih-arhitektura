package com.osa.osaproject.controller;

import com.osa.osaproject.model.Stavka;
import com.osa.osaproject.service.StavkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stavke")
public class StavkaController {

    private static Logger logger = LoggerFactory.getLogger(StavkaController.class);

    private final StavkaService service;

    public StavkaController(StavkaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Stavka>> findAll() {
        logger.info("GET '/api/v1/stavke': Finding all items.");

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stavka> findById(@PathVariable("id") Long id) {
        logger.info("GET '/api/v1/stavke/{}': Finding item by it's id: {}.", id);

        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Stavka> create(@RequestBody Stavka create) {
        logger.info("POST '/api/v1/stavke: Creating a new item.'");

        return ResponseEntity.ok(service.create(create));
    }
}

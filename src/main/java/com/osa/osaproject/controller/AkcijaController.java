package com.osa.osaproject.controller;

import com.osa.osaproject.model.Akcija;
import com.osa.osaproject.service.AkcijaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/akcije")
public class AkcijaController {

    private static Logger logger = LoggerFactory.getLogger(AkcijaController.class);

    private final AkcijaService service;

    public AkcijaController(AkcijaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Akcija>> findAll() {
        logger.info("GET '/api/v1/akcije': Finding all akcije.");
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<Akcija> create(@RequestBody Akcija create) {
        logger.info("POST 'api/v1/akcije': Creating akcija");
        return ResponseEntity.ok(service.create(create));
    }
}

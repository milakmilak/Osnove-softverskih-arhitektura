package com.osa.osaproject.controller;

import com.osa.osaproject.model.Akcija;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.service.ProdavacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodavci")
public class ProdavacController {

    private static Logger logger = LoggerFactory.getLogger(ProdavacController.class);

    private final ProdavacService service;

    public ProdavacController(ProdavacService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Prodavac>> findAll() {
        logger.info("GET '/api/v1/prodavci': Finding all prodavci.");
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Prodavac> getByUsername(@PathVariable("username") String username) {
        logger.info("GET '/api/v1/prodavci/{username}': Finding prodavac by it's username.");
        return ResponseEntity.ok(service.findByUsername(username));
    }

    @PreAuthorize("hasAnyRole('ROLE_PRODAVAC', 'ROLE_KUPAC')")
    @GetMapping("/{username}/artikli")
    public ResponseEntity<List<Artikal>> findArtikliByProdavacUsername(@PathVariable("username") String username) {
        Prodavac found = service.findByUsername(username);

        logger.info("GET '/api/v1/prodavci/{username}/artikli': Finding artikli of prodavac by his username");
        return ResponseEntity.ok(found.getArtikli());
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @GetMapping("/{username}/akcije")
    public ResponseEntity<List<Akcija>> findAkcijeByProdavacUsername(@PathVariable("username") String username) {
        Prodavac found = service.findByUsername(username);

        logger.info("GET '/api/v1/prodavci/{username}/akcije': Finding akcije of prodavac by his username.");
        return ResponseEntity.ok(found.getAkcije());
    }
}

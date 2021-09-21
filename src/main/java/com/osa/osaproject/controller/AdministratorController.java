package com.osa.osaproject.controller;

import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.service.AdministratorService;
import com.osa.osaproject.service.KupacService;
import com.osa.osaproject.service.ProdavacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/korisnici")
public class AdministratorController {

    private static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);

    private final KupacService kupacService;
    private final ProdavacService prodavacService;

    public AdministratorController(KupacService kupacService, ProdavacService prodavacService) {
        this.kupacService = kupacService;
        this.prodavacService = prodavacService;
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @GetMapping("/kupci")
    public ResponseEntity<List<Kupac>> findAllKupci() {
        logger.info("GET '/api/v1/korisnici/kupci': Finding all buyers.");

        return ResponseEntity.ok(kupacService.findAll());
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @GetMapping("/prodavci")
    public ResponseEntity<List<Prodavac>> findAllProdavci() {
        logger.info("GET '/api/v1/korisnici/prodavci': Finding all sellers.");

        return ResponseEntity.ok(prodavacService.findAll());
    }
}

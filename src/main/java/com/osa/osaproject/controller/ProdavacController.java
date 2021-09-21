package com.osa.osaproject.controller;

import com.osa.osaproject.model.Akcija;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.service.ProdavacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prodavci")
public class ProdavacController {

    private static Logger logger = LoggerFactory.getLogger(ProdavacController.class);

    private final ProdavacService service;
    private final PasswordEncoder encoder;

    public ProdavacController(ProdavacService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @PreAuthorize("hasAnyRole('ROLE_KUPAC', 'ROLE_PRODAVAC', 'ROLE_ADMINISTRATOR')")
    @GetMapping
    public ResponseEntity<List<Prodavac>> findAll() {
        logger.info("GET '/api/v1/prodavci': Finding all sellers.");

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Prodavac> getByUsername(@PathVariable("username") String username) {
        logger.info("GET '/api/v1/prodavci/{}': Finding seller by his username: {}", username);

        return ResponseEntity.ok(service.findByUsername(username));
    }

    @PreAuthorize("hasAnyRole('ROLE_PRODAVAC', 'ROLE_KUPAC')")
    @GetMapping("/{username}/artikli")
    public ResponseEntity<List<Artikal>> findArtikliByProdavacUsername(@PathVariable("username") String username) {
        Prodavac found = service.findByUsername(username);

        logger.info("GET '/api/v1/prodavci/{}/artikli': Finding articles of a seller by his username: {}", username);

        return ResponseEntity.ok(found.getArtikli());
    }

    @PreAuthorize("hasAnyRole('ROLE_PRODAVAC', 'ROLE_KUPAC')")
    @GetMapping("/{username}/akcije")
    public ResponseEntity<List<Akcija>> findAkcijeByProdavacUsername(@PathVariable("username") String username) {
        Prodavac found = service.findByUsername(username);

        logger.info("GET '/api/v1/prodavci/{}/akcije': Finding actions of seller by his username: {}.", username);

        return ResponseEntity.ok(found.getAkcije());
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Prodavac> block(@PathVariable("id") Long id, @RequestBody Boolean isBlokiran) {
        Prodavac blocked = service.block(id, isBlokiran);

        logger.info("PUT '/api/v1/prodavci/{}': Blocking seller with id: {}", id);

        return ResponseEntity.ok(blocked);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_PRODAVAC')")
    @PutMapping("/update/{username}")
    public ResponseEntity<Prodavac> update(@PathVariable("username") String username, String ime, String prezime, String newUsername, String newPassword) {
        Prodavac found = service.findByUsername(username);

        found.setUsername(newUsername);
        found.setIme(ime);
        found.setPrezime(prezime);
        found.setPassword(encoder.encode(found.getPassword()));

        logger.info("PUT '/api/v1/prodavci/update/{}': Updated sellers credentials with username: {}", username);

        return ResponseEntity.ok(service.create(found));
    }

}

package com.osa.osaproject.controller;

import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.service.KupacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kupci")
public class KupacController {

    private static final Logger logger = LoggerFactory.getLogger(KupacController.class);

    private final KupacService service;
    private final PasswordEncoder encoder;

    public KupacController(KupacService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Kupac> findByUsername(@PathVariable("username") String username) {
        logger.info("GET '/api/v1/kupci/{}': Finding buyer by his username: {}", username);

        return ResponseEntity.ok(service.findByUsername(username));
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @PutMapping("/{id}")
    public ResponseEntity<Kupac> block(@PathVariable("id") Long id, @RequestBody Boolean isBlokiran) {
        Kupac blocked = service.block(id, isBlokiran);

        logger.info("PUT '/api/v1/kupci/{}': Updating buyer with id: {}", id);

        return ResponseEntity.ok(blocked);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_KUPAC')")
    @PutMapping("/update/{username}")
    public ResponseEntity<Kupac> update(@PathVariable("username") String username, String ime, String prezime, String newUsername, String newPassword) {
        Kupac found = service.findByUsername(username);

        found.setUsername(newUsername);
        found.setIme(ime);
        found.setPrezime(prezime);
        found.setPassword(encoder.encode(found.getPassword()));

        logger.info("PUT '/api/v1/kupci/update/{}': Updated buyers credentials with username: {}", username);

        return ResponseEntity.ok(service.create(found));
    }
}

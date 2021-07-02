package com.osa.osaproject.controller;

import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.model.Role;
import com.osa.osaproject.service.KupacService;
import com.osa.osaproject.service.ProdavacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final KupacService kupacService;
    private final ProdavacService prodavacService;

    public RegistrationController(KupacService kupacService, ProdavacService prodavacService) {
        this.kupacService = kupacService;
        this.prodavacService = prodavacService;
    }

    @PostMapping("/kupac")
    public ResponseEntity<?> register(@RequestBody Kupac kupac) {
        kupac.setRole(Role.ROLE_KUPAC);
        kupac.setIsBlokiran(false);

        kupac.setPorudzbine(new ArrayList<>());

        logger.info("POST '/api/v1/registration': Registrating KUPAC.");
        return ResponseEntity.ok(kupacService.create(kupac));
    }

    @PostMapping("/prodavac")
    public ResponseEntity<?> register(@RequestBody Prodavac prodavac) {
        prodavac.setRole(Role.ROLE_PRODAVAC);
        prodavac.setIsBlokiran(false);
        prodavac.setPoslujeOd(LocalDate.now());

        prodavac.setArtikli(new ArrayList<>());
        prodavac.setAkcija(new ArrayList<>());

        logger.info("POST '/api/v1/registration': Registrating PRODAVAC.");
        return ResponseEntity.ok(prodavacService.create(prodavac));
    }

}

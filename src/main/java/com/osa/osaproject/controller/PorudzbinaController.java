package com.osa.osaproject.controller;

import com.osa.osaproject.model.Porudzbina;
import com.osa.osaproject.service.PorudzbinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/porudzbine")
public class PorudzbinaController {

    private final PorudzbinaService service;

    public PorudzbinaController(PorudzbinaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Porudzbina> create(@RequestBody Porudzbina create) {
        return ResponseEntity.ok(service.create(create));
    }
}

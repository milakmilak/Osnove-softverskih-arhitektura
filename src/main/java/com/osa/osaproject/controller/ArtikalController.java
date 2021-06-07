package com.osa.osaproject.controller;

import com.osa.osaproject.dto.ArtikalDto;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.service.ArtikalService;
import com.osa.osaproject.util.ArtikalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artikli")
public class ArtikalController {

    @Autowired
    private ArtikalService service;

    @Autowired
    private ArtikalMapper mapper;

    @GetMapping
    public ResponseEntity<List<ArtikalDto>> findAll() {
        List<Artikal> found = service.findAll();
        List<ArtikalDto> converted = mapper.mapToArtikalsDto(found);

        return ResponseEntity.ok(converted);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_KUPAC', 'ROLE_PRODAVAC')")
    @GetMapping("/{id}")
    public ResponseEntity<ArtikalDto> findById(@PathVariable("id") Long id) {
        Artikal found = service.findById(id);
        ArtikalDto converted = mapper.mapToArtikalDto(found);

        return ResponseEntity.ok(converted);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @PostMapping
    public ResponseEntity<Artikal> create(@RequestBody ArtikalDto dto) {
        Artikal created = mapper.mapToArtikal(dto);
        created = service.create(created);

        return ResponseEntity.ok(created);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @PutMapping("/{id}")
    public ResponseEntity<Artikal> update(@PathVariable("id") Long id, @RequestBody ArtikalDto update) {
        Artikal updated = service.findById(id);
        Artikal converted = mapper.mapToArtikal(id, update);

        updated = service.update(id, converted);

        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}

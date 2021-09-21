package com.osa.osaproject.controller;

import com.osa.osaproject.dto.ArtikalDto;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.service.ArtikalService;
import com.osa.osaproject.util.ArtikalMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artikli")
public class ArtikalController {

    private static Logger logger = LoggerFactory.getLogger(ArtikalController.class);

    @Autowired
    private ArtikalService service;

    @Autowired
    private ArtikalMapper mapper;

    @GetMapping
    public ResponseEntity<List<ArtikalDto>> findAll() {
        List<Artikal> found = service.findAll();
        List<ArtikalDto> converted = mapper.mapToArtikalsDto(found);

        logger.info("GET '/api/v1/artikli': Finding all articles.");

        return ResponseEntity.ok(converted);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR', 'ROLE_KUPAC', 'ROLE_PRODAVAC')")
    @GetMapping("/{id}")
    public ResponseEntity<ArtikalDto> findById(@PathVariable("id") Long id) {
        Artikal found = service.findById(id);
        ArtikalDto converted = mapper.mapToArtikalDto(found);

        logger.info("GET '/api/v1/artikli/{}': Finding article by it's id: {}", id);

        return ResponseEntity.ok(converted);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @PostMapping
    public ResponseEntity<Artikal> create(@RequestBody ArtikalDto dto) {
        Artikal created = mapper.mapToArtikal(dto);
        created = service.create(created);

        logger.info("POST '/api/v1/artikli': Creating article.");

        return ResponseEntity.ok(created);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @PutMapping("/{id}")
    public ResponseEntity<Artikal> update(@PathVariable("id") Long id, @RequestBody ArtikalDto update) {
        Artikal updated = service.findById(id);
        Artikal converted = mapper.mapToArtikal(id, update);

        updated = service.update(id, converted);

        logger.info("PUT '/api/v1/artikli/{}': Updating article with id: {}", id);

        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasRole('ROLE_PRODAVAC')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        logger.info("DELETE '/api/v1/artikli/{}': Deleting article with id: {}", id);

        service.delete(id);
    }

}

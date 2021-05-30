package com.osa.osaproject.controller;

import com.osa.osaproject.dto.ArtikalDto;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.service.ArtikalService;
import com.osa.osaproject.util.ArtikalMapper;
import org.springframework.http.ResponseEntity;
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

    private final ArtikalService service;
    private final ArtikalMapper mapper;

    public ArtikalController(ArtikalService service, ArtikalMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ArtikalDto>> findAll() {
        List<Artikal> found = service.findAll();
        List<ArtikalDto> converted = mapper.maptoArtikalsDto(found);

        return ResponseEntity.ok(converted);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtikalDto> findById(@PathVariable("id") Long id) {
        Artikal found = service.findById(id);
        ArtikalDto converted = mapper.mapToArtikalDto(found);

        return ResponseEntity.ok(converted);
    }

    @PostMapping
    public ResponseEntity<Artikal> create(@RequestBody ArtikalDto dto) {
        Artikal created = mapper.mapToArtikal(dto);
        created = service.create(created);

        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artikal> update(@PathVariable("id") Long id, @RequestBody ArtikalDto update) {
        Artikal updated = service.findById(id);
        Artikal converted = mapper.mapToArtikal(id, update);

        updated = service.update(id, converted);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}

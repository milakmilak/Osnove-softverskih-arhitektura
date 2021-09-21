package com.osa.osaproject.util;

import com.osa.osaproject.dto.ArtikalDto;
import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.service.AkcijaService;
import com.osa.osaproject.service.ProdavacService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtikalMapper {

    private final ProdavacService prodavacService;
    private final AkcijaService akcijaService;

    public ArtikalMapper(ProdavacService prodavacService, AkcijaService akcijaService) {
        this.prodavacService = prodavacService;
        this.akcijaService = akcijaService;
    }

    //Converting ARTIKAL's to DTO's for GET request
    public List<ArtikalDto> mapToArtikalsDto(List<Artikal> artikali) {
        List<ArtikalDto> converted = artikali.stream()
                .map(this::mapToArtikalDto)
                .collect(Collectors.toList());

        return converted;
    }

    //Converting ARTIKAL to DTO for GET request
    public ArtikalDto mapToArtikalDto(Artikal artikal) {
        ArtikalDto converted = new ArtikalDto();

        converted.setId(artikal.getId());
        converted.setNaziv(artikal.getNaziv());
        converted.setOpis(artikal.getOpis());
        converted.setCena(artikal.getCena());
        converted.setProdavac(artikal.getProdavac());
        converted.setPutanjaSlike(artikal.getPutanjaSlike());

        return converted;
    }

    //Converting DTO to ARTIKAL for POST request
    public Artikal mapToArtikal(ArtikalDto dto) {
        Artikal converted = new Artikal();

        converted.setNaziv(dto.getNaziv())
                .setOpis(dto.getOpis())
                .setCena(dto.getCena())
                .setPutanjaSlike(dto.getPutanjaSlike())
                .setAkcija(akcijaService.findByIds(dto.getAkcijeIds()))
                //.setProdavac(prodavacService.findById(dto.getProdavacId()));
                .setProdavac(dto.getProdavac());

        return converted;
    }

    //Converting DTO to ARTIKAL for PUT request
    public Artikal mapToArtikal(Long id, ArtikalDto dto) {
        Artikal converted = new Artikal();

        converted.setId(id)
                .setNaziv(dto.getNaziv())
                .setId(dto.getId())
                .setOpis(dto.getOpis())
                .setCena(dto.getCena())
                .setPutanjaSlike(dto.getPutanjaSlike());
                //.setProdavac(prodavacService.findById(dto.getProdavacId()))
                //.setProdavac(dto.getProdavac())
                //.setAkcija(akcijaService.findByIds(dto.getAkcijeIds()));

        return converted;
    }

}

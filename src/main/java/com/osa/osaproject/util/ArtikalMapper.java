package com.osa.osaproject.util;

import com.osa.osaproject.dto.ArtikalDto;
import com.osa.osaproject.model.Artikal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtikalMapper {

    //Converting ARTIKAL's to DTO's for GET request
    public List<ArtikalDto> maptoArtikalsDto(List<Artikal> artikali) {
        List<ArtikalDto> converted = artikali.stream()
                .map(this::mapToArtikalDto)
                .collect(Collectors.toList());

        return converted;
    }

    //Converting ARTIKAL to DTO for GET request
    public ArtikalDto mapToArtikalDto(Artikal artikal) {
        ArtikalDto converted = new ArtikalDto(artikal.getId(), artikal.getNaziv(), artikal.getOpis(), artikal.getCena());

        return converted;
    }

    //Converting DTO to ARTIKAL for POST request
    public Artikal mapToArtikal(ArtikalDto dto) {
        Artikal converted = new Artikal();

        converted.setNaziv(dto.getNaziv())
                .setOpis(dto.getOpis())
                .setCena(dto.getCena())
                .setPutanjaSlike(dto.getPutanjaSlike());

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
                .setPutanjaSlike(dto.getPutanjaSlike())
                .setProdavac(dto.getProdavac())
                .setAkcija(dto.getAkcije());

        return converted;
    }

}

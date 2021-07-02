package com.osa.osaproject.dto;

import com.osa.osaproject.model.Prodavac;

import java.util.List;

public class ArtikalDto {

    private Long id;

    private String naziv;
    private String opis;
    private String putanjaSlike;

    private Double cena;

    //private Long prodavacId;
    private Prodavac prodavac;

    private List<Long> akcijeIds;

    public ArtikalDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getPutanjaSlike() {
        return putanjaSlike;
    }

    public void setPutanjaSlike(String putanjaSlike) {
        this.putanjaSlike = putanjaSlike;
    }

    /*public Long getProdavacId()
    {
        return prodavacId;
    }

    public void setProdavacId(Long prodavacId) {
        this.prodavacId = prodavacId;
    }*/

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public List<Long> getAkcijeIds() {
        return akcijeIds;
    }

    public void setAkcijeIds(List<Long> akcijeIds) {
        this.akcijeIds = akcijeIds;
    }
}

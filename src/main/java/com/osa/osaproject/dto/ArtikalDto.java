package com.osa.osaproject.dto;

import com.osa.osaproject.model.Akcija;
import com.osa.osaproject.model.Prodavac;

import java.util.List;

public class ArtikalDto {

    private Long id;
    private String naziv, opis;

    private Double cena;

    private String putanjaSlike;

    private Prodavac prodavac;

    private List<Akcija> akcije;

    public ArtikalDto() {
    }

    //GET request constructor
    public ArtikalDto(Long id, String naziv, String opis, Double cena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    //POST request constructor
    public ArtikalDto(String naziv, String opis, Double cena, String putanjaSlike) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.putanjaSlike = putanjaSlike;
    }

    //PUT request constructor
    public ArtikalDto(Long id, String naziv, String opis, Double cena, String putanjaSlike, Prodavac prodavac, List<Akcija> akcije) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.putanjaSlike = putanjaSlike;
        this.prodavac = prodavac;
        this.akcije = akcije;
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

    public Prodavac getProdavac() {
        return prodavac;
    }

    public void setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
    }

    public List<Akcija> getAkcije() {
        return akcije;
    }

    public void setAkcije(List<Akcija> akcije) {
        this.akcije = akcije;
    }
}

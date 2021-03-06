package com.osa.osaproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Artikal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Long id;

    private String naziv;
    private String opis;

    private Double cena;

    @Lob
    private String putanjaSlike;

    @ManyToOne
    private Prodavac prodavac; //koji prodavac(korisnik) prodaje ovaj artikal

//    @OneToMany
    @ManyToMany
    @JoinTable(
            name="artikal_akcija_test",
            joinColumns = @JoinColumn(name = "artikal_id"),
            inverseJoinColumns = @JoinColumn(name = "akcija_id")
    )
    private List<Akcija> akcija; // lista akcija na kojim se nalazi ovaj artikal, npr nalazi se na novogodisnjoj i na uskrsnjoj akciji(lupam, primer), pa spisak svih tih akcija

    public Artikal() {

    }

    public Artikal(String naziv, String opis, Double cena, String putanjaSlike, Prodavac prodavac, List<Akcija> akcija) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.putanjaSlike = putanjaSlike;
        this.prodavac = getProdavac();
        this.akcija = akcija;
    }

    public Long getId() {
        return id;
    }

    public Artikal setId(java.lang.Long id) {
        this.id = id;
        return this;
    }

    public String getNaziv() {
        return naziv;
    }

    public Artikal setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public String getOpis() {
        return opis;
    }

    public Artikal setOpis(String opis) {
        this.opis = opis;
        return this;
    }

    public Double getCena() {
        return cena;
    }

    public Artikal setCena(Double cena) {
        this.cena = cena;
        return this;
    }

    public String getPutanjaSlike() {
        return putanjaSlike;
    }

    public Artikal setPutanjaSlike(String putanjaSlike) {
        this.putanjaSlike = putanjaSlike;
        return this;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public Artikal setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
        return this;
    }

    public List<Akcija> getAkcija() {
        return akcija;
    }

    public Artikal setAkcija(List<Akcija> akcija) {
        this.akcija = akcija;
        return this;
    }
}

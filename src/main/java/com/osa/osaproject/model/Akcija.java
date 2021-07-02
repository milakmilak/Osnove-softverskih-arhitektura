package com.osa.osaproject.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Akcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer procenat;

    private LocalDate odKad;
    private LocalDate doKad;

    private String tekst;

    @OneToMany
    private List<Artikal> artikliNaAkciji;

    @ManyToOne
    private Prodavac prodavac;// prodavac koji je napravio akciju

    public Akcija() {

    }

    public Akcija(Integer procenat, LocalDate odKad, LocalDate doKad, String tekst, List<Artikal> artikliNaAkciji, Prodavac prodavac) {
        this.procenat = procenat;
        this.odKad = odKad;
        this.doKad = doKad;
        this.tekst = tekst;
        this.artikliNaAkciji = artikliNaAkciji;
        this.prodavac = prodavac;
    }

    public Long getId() {
        return id;
    }

    public Akcija setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getProcenat() {
        return procenat;
    }

    public Akcija setProcenat(Integer procenat) {
        this.procenat = procenat;
        return this;
    }

    public LocalDate getOdKad() {
        return odKad;
    }

    public Akcija setOdKad(LocalDate odKad) {
        this.odKad = odKad;
        return this;
    }

    public LocalDate getDoKad() {
        return doKad;
    }

    public Akcija setDoKad(LocalDate doKad) {
        this.doKad = doKad;
        return this;
    }

    public String getTekst() {
        return tekst;
    }

    public Akcija setTekst(String tekst) {
        this.tekst = tekst;
        return this;
    }

    public List<Artikal> getArtikliNaAkciji() {
        return artikliNaAkciji;
    }

    public Akcija setArtikliNaAkciji(List<Artikal> artikliNaAkciji) {
        this.artikliNaAkciji = artikliNaAkciji;
        return this;
    }

    public Prodavac getProdavac() {
        return prodavac;
    }

    public Akcija setProdavac(Prodavac prodavac) {
        this.prodavac = prodavac;
        return this;
    }
}

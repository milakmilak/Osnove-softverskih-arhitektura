package com.osa.osaproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stavka {

    /**
     * Objekat koji nam sluzi kao sprega imedju porudzbine i artikla
     *
     * Stavka nam je neki "pomocni objekat", govori koji artikal, koliko komada i kroz koju porudzbinu je narucen
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer kolicina; // broj komada tog artikla

    @ManyToOne
    private Porudzbina porudzbina; // koja je porudzbina u pitanju

    @OneToOne
    private Artikal artikal; // koji je artikal u pitanju

    public Stavka() {

    }

    public Stavka(Integer kolicina, Porudzbina porudzbina, Artikal artikal) {
        this.kolicina = kolicina;
        this.porudzbina = porudzbina;
        this.artikal = artikal;
    }

    public Long getId() {
        return id;
    }

    public Stavka setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public Stavka setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
        return this;
    }

    public Porudzbina getPorudzbina() {
        return porudzbina;
    }

    public Stavka setPorudzbina(Porudzbina porudzbina) {
        this.porudzbina = porudzbina;
        return this;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public Stavka setArtikal(Artikal artikal) {
        this.artikal = artikal;
        return this;
    }
}

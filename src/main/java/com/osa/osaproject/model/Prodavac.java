package com.osa.osaproject.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Prodavac extends Korisnik {

    private LocalDate poslujeOd;
    private String email;
    private String adresa;
    private String naziv;

    @OneToMany
    private List<Artikal> artikli;// artikli koje prodavac prodaje

    @OneToMany
    private List<Akcija> akcije;

    public Prodavac() {
        super();
    }

    public Prodavac(Long id, String ime, String prezime, String username, String password, boolean blokiran,
                    LocalDate poslujeOd, String email, String adresa, String naziv, List<Artikal> artikli, List<Akcija> akcije) {
        super(id, ime, prezime, username, password, blokiran);
        this.poslujeOd = poslujeOd;
        this.email = email;
        this.adresa = adresa;
        this.naziv = naziv;
        this.artikli = artikli;
        this.akcije = akcije;
    }

    public LocalDate getPoslujeOd() {
        return poslujeOd;
    }

    public Prodavac setPoslujeOd(LocalDate poslujeOd) {
        this.poslujeOd = poslujeOd;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Prodavac setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public Prodavac setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getNaziv() {
        return naziv;
    }

    public Prodavac setNaziv(String naziv) {
        this.naziv = naziv;
        return this;
    }

    public List<Artikal> getArtikli() {
        return artikli;
    }

    public Prodavac setArtikli(List<Artikal> artikli) {
        this.artikli = artikli;
        return this;
    }

    public List<Akcija> getAkcije() {
        return akcije;
    }

    public Prodavac setAkcija(List<Akcija> akcije) {
        this.akcije = akcije;
        return this;
    }
}

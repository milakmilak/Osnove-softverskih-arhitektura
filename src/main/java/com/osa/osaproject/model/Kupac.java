package com.osa.osaproject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Kupac extends Korisnik {

    private String adresa;

    @OneToMany
    private List<Porudzbina> porudzbine;// porudzbine koje je kupac porucio

    public Kupac() {
        super();
    }

    public Kupac(Long id, String ime, String prezime, String username, String password, boolean blokiran, Role role, String adresa, List<Porudzbina> porudzbine) {
        super(id, ime, prezime, username, password, blokiran, role);
        this.adresa = adresa;
        this.porudzbine = porudzbine;
    }

    public String getAdresa() {
        return adresa;
    }

    public Kupac setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public List<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public Kupac setPorudzbine(List<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
        return this;
    }
}

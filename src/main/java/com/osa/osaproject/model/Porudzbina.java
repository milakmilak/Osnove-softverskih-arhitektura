package com.osa.osaproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Porudzbina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate satnica;

    private boolean dostavljeno;

    private Integer ocena;

    private String komentar;

    private boolean anonimanKomentar;
    private boolean arhiviranKomentar;

    @OneToOne
    private Kupac kupac;// kupac koji je napravio porudzbinu

    @OneToMany
    private List<Stavka> stavke;// ovde je smesten broj artikala koje je porucio, SPREGA IZMEDJU PORUDZBINE I ARTIKLA

    public Porudzbina() {

    }

    public Porudzbina(LocalDate satnica, boolean dostavljeno, Integer ocena, String komentar,
                      boolean anonimanKomentar, boolean arhiviranKomentar, Kupac kupac, List<Stavka> stavke) {
        this.satnica = satnica;
        this.dostavljeno = dostavljeno;
        this.ocena = ocena;
        this.komentar = komentar;
        this.anonimanKomentar = anonimanKomentar;
        this.arhiviranKomentar = arhiviranKomentar;
        this.kupac = kupac;
        this.stavke = stavke;
    }


    public Long getId() {
        return id;
    }

    public Porudzbina setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getSatnica() {
        return satnica;
    }

    public Porudzbina setSatnica(LocalDate satnica) {
        this.satnica = satnica;
        return this;
    }

    public boolean isDostavljeno() {
        return dostavljeno;
    }

    public Porudzbina setDostavljeno(boolean dostavljeno) {
        this.dostavljeno = dostavljeno;
        return this;
    }

    public Integer getOcena() {
        return ocena;
    }

    public Porudzbina setOcena(Integer ocena) {
        this.ocena = ocena;
        return this;
    }

    public String getKomentar() {
        return komentar;
    }

    public Porudzbina setKomentar(String komentar) {
        this.komentar = komentar;
        return this;
    }

    public boolean isAnonimanKomentar() {
        return anonimanKomentar;
    }

    public Porudzbina setAnonimanKomentar(boolean anonimanKomentar) {
        this.anonimanKomentar = anonimanKomentar;
        return this;
    }

    public boolean isArhiviranKomentar() {
        return arhiviranKomentar;
    }

    public Porudzbina setArhiviranKomentar(boolean arhiviranKomentar) {
        this.arhiviranKomentar = arhiviranKomentar;
        return this;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public Porudzbina setKupac(Kupac kupac) {
        this.kupac = kupac;
        return this;
    }

    public List<Stavka> getStavke() {
        return stavke;
    }

    public Porudzbina setStavke(List<Stavka> stavke) {
        this.stavke = stavke;
        return this;
    }
}

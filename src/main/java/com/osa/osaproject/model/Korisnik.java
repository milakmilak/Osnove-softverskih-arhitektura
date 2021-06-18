package com.osa.osaproject.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen")
    @SequenceGenerator(name = "seq_gen", initialValue = 2)
    private Long id;

    private String ime;
    private String prezime;
    private String username;
    private String password;

    private boolean isBlokiran;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Korisnik() {

    }

    public Korisnik(Long id, String ime, String prezime, String username, String password, boolean isBlokiran, Role role) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.isBlokiran = isBlokiran;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Korisnik setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIme() {
        return ime;
    }

    public Korisnik setIme(String ime) {
        this.ime = ime;
        return this;
    }

    public String getPrezime() {
        return prezime;
    }

    public Korisnik setPrezime(String prezime) {
        this.prezime = prezime;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Korisnik setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Korisnik setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isIsBlokiran() {
        return isBlokiran;
    }

    public Korisnik setIsBlokiran(boolean blokiran) {
        this.isBlokiran = blokiran;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

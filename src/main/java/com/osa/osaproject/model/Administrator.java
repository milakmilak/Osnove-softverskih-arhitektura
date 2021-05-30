package com.osa.osaproject.model;

import javax.persistence.Entity;

@Entity
public class Administrator extends Korisnik {

    public Administrator() {
        super();
    }

    public Administrator(Long id, String ime, String prezime, String username, String password, boolean blokiran) {
        super(id, ime, prezime, username, password, blokiran);
    }
}

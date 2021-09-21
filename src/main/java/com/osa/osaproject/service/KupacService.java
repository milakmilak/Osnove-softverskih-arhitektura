package com.osa.osaproject.service;

import com.osa.osaproject.model.Kupac;

import java.util.List;

public interface KupacService {

    List<Kupac> findAll();
    Kupac findById(Long id);
    Kupac findByUsername(String username);
    Kupac create(Kupac kupac);
    Kupac update(Long id, Kupac update);
    Kupac block(Long id, Boolean isBlokiran);
    void delete(Long id);

}

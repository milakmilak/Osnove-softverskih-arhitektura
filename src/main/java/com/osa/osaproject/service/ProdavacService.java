package com.osa.osaproject.service;

import com.osa.osaproject.model.Prodavac;

import java.util.List;

public interface ProdavacService {

    List<Prodavac> findAll();
    Prodavac findById(Long id);
    Prodavac findByUsername(String username);
    Prodavac create(Prodavac prodavac);
    Prodavac update(Long id, Prodavac update);
    void delete(Long id);

}

package com.osa.osaproject.service;

import com.osa.osaproject.model.Artikal;

import java.util.List;

public interface ArtikalService {

    List<Artikal> findAll();
    Artikal findById(Long id);
    Artikal create(Artikal artikal);
    Artikal update(Long id, Artikal update);
    void delete(Long id);

}

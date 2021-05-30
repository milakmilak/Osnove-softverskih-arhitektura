package com.osa.osaproject.service;

import com.osa.osaproject.model.Stavka;

import java.util.List;

public interface StavkaService {

    List<Stavka> findAll();
    Stavka findById(Long id);
    Stavka create(Stavka stavka);
    Stavka update(Long id, Stavka update);
    void delete(Long id);

}

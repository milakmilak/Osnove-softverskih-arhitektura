package com.osa.osaproject.service;

import com.osa.osaproject.model.Porudzbina;

import java.util.List;

public interface PorudzbinaService {

    List<Porudzbina> findAll();
    Porudzbina findById(Long id);
    Porudzbina create(Porudzbina porudzbina);
    Porudzbina update(Long id, Porudzbina update);
    void delete(Long id);

}

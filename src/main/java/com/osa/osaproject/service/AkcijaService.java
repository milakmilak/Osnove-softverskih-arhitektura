package com.osa.osaproject.service;

import com.osa.osaproject.model.Akcija;

import java.util.List;

public interface AkcijaService {

    List<Akcija> findAll();
    Akcija findById(Long id);
    Akcija create(Akcija akcija);
    Akcija update(Long id, Akcija update);
    void delete(Long id);

}

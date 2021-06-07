package com.osa.osaproject.service;

import com.osa.osaproject.model.Administrator;

import java.util.List;

public interface AdministratorService {

    List<Administrator> findAll();
    Administrator findById(Long id);
    Administrator findByUsername(String username);
    Administrator create(Administrator administrator);
    Administrator update(Long id, Administrator update);
    void delete(Long id);

}

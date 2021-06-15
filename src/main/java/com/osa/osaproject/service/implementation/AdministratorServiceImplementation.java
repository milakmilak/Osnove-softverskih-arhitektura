package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Administrator;
import com.osa.osaproject.repository.AdministratorRepository;
import com.osa.osaproject.service.AdministratorService;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdministratorServiceImplementation implements AdministratorService {

    private final AdministratorRepository repository;

    public AdministratorServiceImplementation(AdministratorRepository repository) {
        this.repository = repository;
    }

    @Override
    @ReadOnlyProperty
    public List<Administrator> findAll() {
        return repository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Administrator findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Administrator findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    @Transactional
    public Administrator create(Administrator administrator) {
        return repository.save(administrator);
    }

    @Override
    @Transactional
    public Administrator update(Long id, Administrator update) {
        Administrator updated = repository.findById(id).get();

        updated.setIme(update.getIme())
                .setPrezime(update.getPrezime())
                .setUsername(update.getUsername())
                .setPassword(update.getPassword())
                .setIsBlokiran(update.isIsBlokiran());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Administrator deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

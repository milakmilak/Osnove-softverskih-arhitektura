package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Stavka;
import com.osa.osaproject.repository.StavkaRepository;
import com.osa.osaproject.service.StavkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StavkaServiceImplementation implements StavkaService {

    @Autowired
    private StavkaRepository repository;

    @Override
    @ReadOnlyProperty
    public List<Stavka> findAll() {
        return repository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Stavka findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Stavka create(Stavka stavka) {
        return repository.save(stavka);
    }

    @Override
    @Transactional
    public Stavka update(Long id, Stavka update) {
        Stavka updated = repository.findById(id).get();

        updated.setKolicina(update.getKolicina())
                .setPorudzbina(update.getPorudzbina())
                .setArtikal(update.getArtikal());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Stavka deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Stavka;
import com.osa.osaproject.repository.StavkaRepository;
import com.osa.osaproject.service.StavkaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StavkaServiceImplementation implements StavkaService {

    private final StavkaRepository repository;

    public StavkaServiceImplementation(StavkaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Stavka> findAll() {
        return repository.findAll();
    }

    @Override
    public Stavka findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Stavka create(Stavka stavka) {
        return repository.save(stavka);
    }

    @Override
    public Stavka update(Long id, Stavka update) {
        Stavka updated = repository.findById(id).get();

        updated.setKolicina(update.getKolicina())
                .setPorudzbina(update.getPorudzbina())
                .setArtikal(update.getArtikal());

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Stavka deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

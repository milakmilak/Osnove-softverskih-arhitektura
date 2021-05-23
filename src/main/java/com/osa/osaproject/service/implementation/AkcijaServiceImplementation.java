package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Akcija;
import com.osa.osaproject.repository.AkcijaRepository;
import com.osa.osaproject.service.AkcijaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AkcijaServiceImplementation implements AkcijaService {

    private final AkcijaRepository repository;

    public AkcijaServiceImplementation(AkcijaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Akcija> findAll() {
        return repository.findAll();
    }

    @Override
    public Akcija findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Akcija create(Akcija akcija) {
        return repository.save(akcija);
    }

    @Override
    public Akcija update(Long id, Akcija update) {
        Akcija updated = repository.findById(id).get();

        updated.setProcenat(update.getProcenat())
                .setOdKad(update.getOdKad())
                .setDoKad(update.getDoKad())
                .setTekst(update.getTekst())
                .setArtikliNaAkciji(update.getArtikliNaAkciji())
                .setProdavac(update.getProdavac());

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Akcija deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

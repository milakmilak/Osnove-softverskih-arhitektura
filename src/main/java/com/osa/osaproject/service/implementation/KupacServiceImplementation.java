package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.repository.KupacRepository;
import com.osa.osaproject.service.KupacService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacServiceImplementation implements KupacService {

    private final KupacRepository repository;

    public KupacServiceImplementation(KupacRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Kupac> findAll() {
        return repository.findAll();
    }

    @Override
    public Kupac findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Kupac create(Kupac kupac) {
        return repository.save(kupac);
    }

    @Override
    public Kupac update(Long id, Kupac update) {
        Kupac updated = repository.findById(id).get();

        updated.setPorudzbine(update.getPorudzbine())
                .setAdresa(update.getAdresa())
                .setIme(update.getIme())
                .setPrezime(update.getPrezime())
                .setUsername(update.getUsername())
                .setPassword(update.getPassword())
                .setBlokiran(update.isBlokiran());

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Kupac deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

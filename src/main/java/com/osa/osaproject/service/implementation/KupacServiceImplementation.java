package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Kupac;
import com.osa.osaproject.repository.KupacRepository;
import com.osa.osaproject.service.KupacService;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class KupacServiceImplementation implements KupacService {

    private final KupacRepository repository;

    public KupacServiceImplementation(KupacRepository repository) {
        this.repository = repository;
    }

    @Override
    @ReadOnlyProperty
    public List<Kupac> findAll() {
        return repository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Kupac findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Kupac findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    @Transactional
    public Kupac create(Kupac kupac) {
        return repository.save(kupac);
    }

    @Override
    @Transactional
    public Kupac update(Long id, Kupac update) {
        Kupac updated = repository.findById(id).get();

        updated.setPorudzbine(update.getPorudzbine())
                .setAdresa(update.getAdresa())
                .setIme(update.getIme())
                .setPrezime(update.getPrezime())
                .setUsername(update.getUsername())
                .setPassword(update.getPassword())
                .setIsBlokiran(update.isIsBlokiran());

        return repository.save(updated);
    }

    @Override
    public Kupac block(Long id, Boolean isBlokiran) {
        Kupac blocked = repository.findById(id).get();
        blocked.setIsBlokiran(isBlokiran);

        return repository.save(blocked);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Kupac deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

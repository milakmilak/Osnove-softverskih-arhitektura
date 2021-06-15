package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.repository.ProdavacRepository;
import com.osa.osaproject.service.ProdavacService;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdavacServiceImplementation implements ProdavacService {

    private final ProdavacRepository repository;

    public ProdavacServiceImplementation(ProdavacRepository repository) {
        this.repository = repository;
    }

    @Override
    @ReadOnlyProperty
    public List<Prodavac> findAll() {
        return repository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Prodavac findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Prodavac findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    @Transactional
    public Prodavac create(Prodavac prodavac) {
        return repository.save(prodavac);
    }

    @Override
    @Transactional
    public Prodavac update(Long id, Prodavac update) {
        Prodavac updated = repository.findById(id).get();

        updated.setAkcija(update.getAkcije())
                .setArtikli(update.getArtikli())
                .setNaziv(update.getNaziv())
                .setAdresa(update.getAdresa())
                .setEmail(update.getEmail())
                .setPoslujeOd(update.getPoslujeOd())
                .setIme(update.getIme())
                .setPrezime(update.getPrezime())
                .setUsername(update.getUsername())
                .setPassword(update.getPassword())
                .setIsBlokiran(update.isIsBlokiran());

        return repository.save(updated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Prodavac deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

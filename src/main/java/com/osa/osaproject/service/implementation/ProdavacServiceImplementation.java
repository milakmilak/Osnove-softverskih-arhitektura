package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Prodavac;
import com.osa.osaproject.repository.ProdavacRepository;
import com.osa.osaproject.service.ProdavacService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdavacServiceImplementation implements ProdavacService {

    private final ProdavacRepository repository;

    public ProdavacServiceImplementation(ProdavacRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prodavac> findAll() {
        return repository.findAll();
    }

    @Override
    public Prodavac findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Prodavac create(Prodavac prodavac) {
        return repository.save(prodavac);
    }

    @Override
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
                .setBlokiran(update.isBlokiran());

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Prodavac deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.repository.ArtikalRepository;
import com.osa.osaproject.service.ArtikalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikalServiceImplementation implements ArtikalService {

    private final ArtikalRepository repository;

    public ArtikalServiceImplementation(ArtikalRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artikal> findAll() {
        return repository.findAll();
    }

    @Override
    public Artikal findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Artikal create(Artikal artikal) {
        return repository.save(artikal);
    }

    @Override
    public Artikal update(Long id, Artikal update) {
        Artikal updated = repository.findById(id).get();

        updated.setNaziv(update.getNaziv())
                .setOpis(update.getOpis())
                .setCena(update.getCena())
                .setPutanjaSlike(update.getPutanjaSlike())
                .setProdavac(update.getProdavac())
                .setAkcija(update.getAkcija());

        return repository.save(updated);
    }

    @Override
    public void delete(Long id) {
        Artikal deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

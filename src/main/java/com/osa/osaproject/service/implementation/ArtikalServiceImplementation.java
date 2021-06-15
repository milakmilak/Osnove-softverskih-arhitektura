package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Artikal;
import com.osa.osaproject.repository.ArtikalRepository;
import com.osa.osaproject.service.ArtikalService;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArtikalServiceImplementation implements ArtikalService {

    private final ArtikalRepository repository;

    public ArtikalServiceImplementation(ArtikalRepository repository) {
        this.repository = repository;
    }

    @Override
    @ReadOnlyProperty
    public List<Artikal> findAll() {
        return repository.findAll();
    }

    @Override
    @ReadOnlyProperty
    public Artikal findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Artikal create(Artikal artikal) {
        return repository.save(artikal);
    }

    @Override
    @Transactional
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
    @Transactional
    public void delete(Long id) {
        Artikal deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

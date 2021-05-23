package com.osa.osaproject.service.implementation;

import com.osa.osaproject.model.Porudzbina;
import com.osa.osaproject.repository.PorudzbinaRepository;
import com.osa.osaproject.service.PorudzbinaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorudzbinaServiceImplementation implements PorudzbinaService {

    private final PorudzbinaRepository repository;

    public PorudzbinaServiceImplementation(PorudzbinaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Porudzbina> findAll() {
        return repository.findAll();
    }

    @Override
    public Porudzbina findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Porudzbina create(Porudzbina porudzbina) {
        return repository.save(porudzbina);
    }

    @Override
    public Porudzbina update(Long id, Porudzbina update) {
        Porudzbina updated = repository.findById(id).get();

        updated.setSatnica(update.getSatnica())
                .setDostavljeno(update.isDostavljeno())
                .setOcena(update.getOcena())
                .setKomentar(update.getKomentar())
                .setAnonimanKomentar(update.isAnonimanKomentar())
                .setArhiviranKomentar(update.isArhiviranKomentar());

        return repository.save(update);
    }

    @Override
    public void delete(Long id) {
        Porudzbina deleted = repository.findById(id).get();
        repository.delete(deleted);
    }
}

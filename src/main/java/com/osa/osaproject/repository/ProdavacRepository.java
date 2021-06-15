package com.osa.osaproject.repository;

import com.osa.osaproject.model.Prodavac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdavacRepository extends JpaRepository<Prodavac, Long> {

    Prodavac findByUsername(String username);

}

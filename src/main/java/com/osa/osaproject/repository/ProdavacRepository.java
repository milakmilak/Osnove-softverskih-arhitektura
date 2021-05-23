package com.osa.osaproject.repository;

import com.osa.osaproject.model.Prodavac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdavacRepository extends JpaRepository<Prodavac, Long> {
}

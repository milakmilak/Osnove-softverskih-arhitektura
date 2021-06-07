package com.osa.osaproject.repository;

import com.osa.osaproject.model.Porudzbina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorudzbinaRepository extends JpaRepository<Porudzbina, Long> {
}

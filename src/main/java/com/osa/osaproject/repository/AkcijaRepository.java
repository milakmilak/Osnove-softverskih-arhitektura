package com.osa.osaproject.repository;

import com.osa.osaproject.model.Akcija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AkcijaRepository extends JpaRepository<Akcija, Long> {
}

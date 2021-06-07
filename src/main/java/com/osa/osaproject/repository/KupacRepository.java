package com.osa.osaproject.repository;

import com.osa.osaproject.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository<Kupac, Long> {

    Kupac findByUsername(String username);

}

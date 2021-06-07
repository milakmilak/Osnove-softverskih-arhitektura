package com.osa.osaproject.repository;

import com.osa.osaproject.model.Stavka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaRepository extends JpaRepository<Stavka, Long> {
}

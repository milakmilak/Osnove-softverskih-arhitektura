package com.osa.osaproject.repository;

import com.osa.osaproject.model.Artikal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtikalRepository extends JpaRepository<Artikal, Long> {
}

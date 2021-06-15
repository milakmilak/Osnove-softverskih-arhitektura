package com.osa.osaproject.repository;

import com.osa.osaproject.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Administrator findByUsername(String username);

}

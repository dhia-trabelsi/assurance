package com.pfe.Societe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SocieteRepository extends JpaRepository<Societe, Integer> {
   
    List<Societe> findAllByAssurance(long id);

}

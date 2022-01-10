package com.api.sic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

}

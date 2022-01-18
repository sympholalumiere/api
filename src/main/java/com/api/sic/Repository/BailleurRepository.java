package com.api.sic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Bailleur;

@Repository
public interface BailleurRepository extends JpaRepository<Bailleur, Integer> {

}

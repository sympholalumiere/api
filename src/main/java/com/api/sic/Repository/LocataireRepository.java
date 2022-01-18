package com.api.sic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Locataire;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Integer>{

}

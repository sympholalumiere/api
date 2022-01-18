package com.api.sic.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Propriete;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete, Integer>{

}

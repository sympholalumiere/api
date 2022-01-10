package com.api.sic.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local , Integer> {
	
	//public List<Local> findByLocalId(int local_id);
	
}

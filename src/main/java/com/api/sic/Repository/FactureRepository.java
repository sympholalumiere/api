package com.api.sic.Repository;

//import java.awt.print.Pageable;
//import java.util.List;

//import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.sic.Entities.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

	

 /*   String query = "select new Facture(" +
            "b.id, b.billDate, b.month, b.year, b.totalExpense, b.totalIncome, " +
            "b.owner1Income, b.owner2Income, b.owner1Personal, b.owner2Personal, " +
            "b.owner1Owe, b.owner2Owe, b.lastUpdated" +
            ") from Bill b";

        @Query(query)
       public List<Facture> summary();

        @Query(query)
       public Page<Facture> summary(Pageable Pageable);
	*/
}
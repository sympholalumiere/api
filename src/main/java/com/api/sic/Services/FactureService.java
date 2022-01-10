package com.api.sic.Services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sic.Entities.Facture;
import com.api.sic.Repository.FactureRepository;

@Service
public class FactureService {
	@Autowired
	private FactureRepository factureRepository;
	
	

	public List<Facture> GetAllFactures(int id){
		List<Facture> factures = new ArrayList<>();
		factureRepository.findById(id)
		.forEach(factures::add);
		return factures;
	}
	
/*	public Optional<Facture> getFacture(long id) {
		//return factures.stream().filter(f -> f.getId()==id).findFirst().get();
		return factureRepository.findById(id);
	}*/
	
	public void addFacture(Facture facture) {
		
		factureRepository.save(facture);
	}
	
	public void updateFacture(int id, Facture facture) {
		/*for(int i=0;i<factures.size();i++) {
			Facture f = factures.get(i);
			if(f.getId()==id) {
				factures.set(i, facture);
				return;
			}
		}*/
		factureRepository.save(facture);
	}
	
	public void deleteFacture(int id) {
		//factures.removeIf(f -> f.getId()==id);
		factureRepository.deleteById(id);
	}

	
}

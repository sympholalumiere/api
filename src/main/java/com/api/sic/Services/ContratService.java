package com.api.sic.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.sic.Entities.Contrat;
import com.api.sic.Repository.ContratRepository;


public class ContratService {
	@Autowired
	private ContratRepository contratRepository;
	
	//service permettant de lister toutes les contrats 
	
	public List<Contrat> GetAllContrats(@PathVariable int locid){
		List<Contrat> contrats= new ArrayList<>();
		contratRepository.findAll().forEach(contrats::add);
		return contrats;
	}
	public Optional<Contrat> getContrat(int locid) {
		//return contrats.stream().filter(c -> c.getId()==id).findFirst().get();
		return contratRepository.findById(locid);
	}
	//service permettant d'ajouter un contrat dans le système
	
	public void addContrat(Contrat contrat) {
		contratRepository.save(contrat);
}
	//service permettant de modifier un contrat dans le système
	
	public void updateContrat(int locid, Contrat contrat) {
		/*for(int i=0;i<contrats.size();i++) {
			Local c = contrats.get(i);
			if(c.getId()==id) {
				contrats.set(i, contrat);
				return;
			}
		}*/
		
		contratRepository.save(contrat);
	}
	
	//service permettant de supprimer un local dans le système
	
	public void deleteContrat(int id) {
		//contrats.removeIf(c -> c.getId()==id);
		contratRepository.deleteById(id);
	}
	

}

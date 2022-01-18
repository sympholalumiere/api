package com.api.sic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.sic.Entities.Contrat;
import com.api.sic.Entities.Locataire;
import com.api.sic.Repository.ContratRepository;
import com.api.sic.Services.ContratService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/tp/contrat")
public class ContratController {
	@Autowired
	private ContratRepository contratRepository;
	private ContratService contratService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/all")
	public List<Contrat> listContrats(){

		  List<Contrat> saliste = contratRepository.findAll();
	    return saliste;
	} 
	
	//Récuperer toutes les contrats d'un client
	@RequestMapping("/users/{id}/contrats")
	public List<Contrat> GetAllContrats(@PathVariable int id){
		return contratService.GetAllContrats(id);	
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/{contrat_id}",method=RequestMethod.GET)
public Contrat getContratById(@PathVariable("contrat_id") int contrat_id) {

    return contratRepository.findById(contrat_id).get();

}
	//Ajouter une Contrat à un locataire
	@RequestMapping(method = RequestMethod.POST, value="/locat/{locid}")
	public void addContrat(@RequestBody Contrat contrat, @PathVariable int locid) {
		contrat.setLocatid (new Locataire());
		contratService.addContrat(contrat);
	} 
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/create/",method=RequestMethod.POST)
public Contrat createContrat(@RequestBody Contrat contrat) {

    return contratRepository.save(contrat);
}
	//Mise à jour d'un contrat
		@RequestMapping(method = RequestMethod.PUT, value="/{id}/contrats/{contid}")
		public void updateContrat(@RequestBody Contrat contrat,@PathVariable int contid) {
			contrat.setLocatid (new Locataire());
			contratService.updateContrat(contid, contrat);
		}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/contrat/",method=RequestMethod.PUT)
public Contrat updateContrat(@RequestBody Contrat local) {

    return contratRepository.save(local);

}
	//suppression d'un contrat
		@RequestMapping(method = RequestMethod.DELETE, value="/{id}/contrats/{contid}")
		public void deleteContrat(@PathVariable int contid) {
			contratService.deleteContrat(contid);
		}
/*	@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/{contrat_id}",method=RequestMethod.DELETE)
public void  deleteContrat(@PathVariable("contrat_id") int localId) {

	contratRepository.deleteById(localId);

}*/

}

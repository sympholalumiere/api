package com.api.sic.Controller;


import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.sic.Entities.Facture;
import com.api.sic.Repository.FactureRepository;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/api/tp/facture")
public class FactureController {
	@Autowired
	private FactureRepository factureRepository;
	
	//Récuperer toutes les factures d'un client
	@GetMapping(value = "/all/{factid}")
	public List<Facture> GetAllFactures(int factid){
		 List<Facture> liste= new ArrayList<>();
		 factureRepository.findAll().forEach(liste::add);;
		return liste;
	
	} 
	/*
	 * //Récuperer toutes les factures d'un client
	 
	 @RequestMapping("/users/{id}/factures")
	public List<Facture> GetAllFacture(){
		return factureService.GetAllFactures();	
	}*/
	
	//Récuperer une facture donnée d'un client donné
	/*
@RequestMapping(value="/{facture_id}",method=RequestMethod.GET)
public Facture GetFactureById(@PathVariable int facture_id) {
	return factureRepository.findById(facture_id);
    

}*/
//Ajouter une facture à un client
@RequestMapping(value="/create/",method=RequestMethod.POST)
public Facture createFacture(@RequestBody Facture facture, @PathVariable int factid) {
	
    return factureRepository.save(facture);
}
/*
@RequestMapping(method = RequestMethod.POST, value="/user/{id}")
public void addFacture(@RequestBody Facture facture, @PathVariable int id) {
	facture.setId (new User());
	factureService.addFacture(facture);
} */

//Mise à jour d'une facture
	/*@RequestMapping(method = RequestMethod.PUT, value="/clients/{id}/factures/{facture_id}")
	public void updateFacture(@RequestBody Facture facture,@PathVariable int facture_id,@PathVariable int id) {
		//facture.setId (new User());
		factureRepository.updateFacture(facture_id, facture);
	}*/
	
@RequestMapping(value="/{factid}/",method=RequestMethod.PUT)
public Facture updateFacture(@RequestBody Facture facture) {

    return factureRepository.save(facture);

}
	
	//suppression d'une facture
	/*@RequestMapping(method = RequestMethod.DELETE, value="/clients/{id}/factures/{facture_id}")
	public void deleteFactures(@PathVariable(" id") int facture_id) {
		factureService.deleteFacture(facture_id);
	}*/
	
@RequestMapping(value="/{factid}",method=RequestMethod.DELETE)
public void  deleteFacture(@PathVariable("factid") int factid) {

	factureRepository.deleteById(factid);

}

}

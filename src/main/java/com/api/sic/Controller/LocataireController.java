package com.api.sic.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.sic.Entities.Locataire;
import com.api.sic.Repository.LocataireRepository;



@RestController
@RequestMapping(value = "/api/tp/locataire")

public class LocataireController {
	@Autowired
	private LocataireRepository locataireRepository;
	//liste de tous les locataires
	@GetMapping(value ="/liste")
	public List<Locataire> getAllBailleurs(){
		 List<Locataire> liste= new ArrayList<>();
		 locataireRepository.findAll().forEach(liste::add);
		return liste;
	}
	// Retourne un locataire par son id 
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Locataire getLocataireById(@PathVariable("id") int locatid) {

	    return locataireRepository.findById(locatid).get();
	}
	public Locataire createLocataire (@RequestBody Locataire  locataire) {

	return this.locataireRepository.save(locataire);



	}

	@RequestMapping(value="/modifie_bail/",method=RequestMethod.PUT)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Locataire updateLocataire(@RequestBody Locataire locataire,int locatid) {

	    return locataireRepository.save(locataire);

	}
	@RequestMapping(value="/{locatid}",method=RequestMethod.DELETE)

	@CrossOrigin(origins = "http://localhost:4200")
	public void  deleteLocataire(@PathVariable("locatid") int locatid) {

		locataireRepository.deleteById(locatid);

	}

}

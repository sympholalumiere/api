package com.api.sic.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.api.sic.Entities.Propriete;
import com.api.sic.Repository.ProprieteRepository;

@RestController
@RequestMapping(value = "/api/tp/Propriete")
public class ProprieteController {
	@Autowired
	private ProprieteRepository proprieteRepository;
	//liste de tous les locataires
	@GetMapping(value ="/liste")
	public List<Propriete> getAllBailleurs(){
		 List<Propriete> liste= new ArrayList<>();
		 proprieteRepository.findAll().forEach(liste::add);
		return liste;
	}
	// Retourne un locataire par son id 
	@RequestMapping(value="/{propid}",method=RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Propriete getProprieteById(@PathVariable("propid") int propid) {

	    return proprieteRepository.findById(propid).get();
	}
	@PostMapping("/nouveau")
	public Propriete createPropriete (@RequestBody Propriete  propriete) {

	return this.proprieteRepository.save(propriete);



	}

	@RequestMapping(value="/modifie_locat/",method=RequestMethod.PUT)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Propriete updatePropriete(@RequestBody Propriete propriete,int propid) {

	    return proprieteRepository.save(propriete);

	}

	//@RequestMapping(value="/{propid}",method=RequestMethod.DELETE)
	@DeleteMapping("/delete/{propid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void  deletePropriete(@PathVariable("propid") int propid) {

		proprieteRepository.deleteById(propid);

	}

}

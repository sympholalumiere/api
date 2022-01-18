package com.api.sic.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.sic.Entities.Bailleur;
import com.api.sic.Repository.BailleurRepository;


@RestController
@RequestMapping(value = "/api/tp/bailleur")
public class BailleurController {
@Autowired
private BailleurRepository bailleurRepository;

//liste de tous les bailleurs
@GetMapping(value ="/liste")
public List<Bailleur> getAllBailleurs(){
	 List<Bailleur> liste= new ArrayList<>();
	 bailleurRepository.findAll().forEach(liste::add);
	return liste;
}
// Retourne un bailleur par son id 
@RequestMapping(value="/{id}",method=RequestMethod.GET)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public Bailleur getBailleurById(@PathVariable("id") int bailleurid) {

    return bailleurRepository.findById(bailleurid).get();
}
@PostMapping("/nouveau")
public Bailleur createBailleur (@RequestBody Bailleur bail) {

return this.bailleurRepository.save(bail);



}

@RequestMapping(value="/modifie_bail/",method=RequestMethod.PUT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public Bailleur updateBailleur(@RequestBody Bailleur bailleur,int id) {

    return bailleurRepository.save(bailleur);

}


@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/delete/{bailleurid}")
public void  deleteBailleur(@PathVariable("bailleurid") int bailleurid) {

	bailleurRepository.deleteById(bailleurid);

}
}


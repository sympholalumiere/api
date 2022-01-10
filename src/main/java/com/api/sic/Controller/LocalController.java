package com.api.sic.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.sic.Entities.Local;
import com.api.sic.Repository.LocalRepository;
import com.api.sic.Services.LocalService;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/sic/locals")
public class LocalController {
	@Autowired
	private LocalRepository localRepository;
	private LocalService localService;

	//Récuperer toutes les locaux 
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/all")
	public List<Local> getAllLocals(){

		  List<Local> saliste = localRepository.findAll();
	    return saliste;
	} 
	

		//Récuperer un local par son id
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/{local_id}")
	public Optional<Local> getLocal(@PathVariable int local_id) {
		return localService.getLocal(local_id);
		
	}

@RequestMapping(value="/{local_id}",method=RequestMethod.GET)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public Optional<Local> getLocalById(@PathVariable("local_id") int local_id) {

    return localRepository.findById(local_id);

}
//Ajouter une maison
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(method = RequestMethod.POST, value="/add")
public void addLocal(@RequestBody Local local) {
	
	localService.CreateLocal(local);
}
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/create/",method=RequestMethod.POST)
public  Local createLocal(@RequestBody Local local) {

    return localRepository.save(local);
}

//mettre a jour un local
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(method = RequestMethod.PUT, value="/{local_id}")
public void updateLocal(@RequestBody Local local,@PathVariable int local_id) {
	
	localService.updateLocal(local_id, local);
}

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/locals/",method=RequestMethod.PUT)
public Local updateLocal(@RequestBody Local local) {

    return localRepository.save(local);

}
//suprimmer un local

@RequestMapping(value="/{local_id}",method=RequestMethod.DELETE)

@CrossOrigin(origins = "http://localhost:4200")
public void  deleteLocal(@PathVariable("local_id") int localId) {

	localRepository.deleteById(localId);

}

}

package com.api.sic.Controller;

import java.util.List;
import java.util.Optional;

//import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;

import com.api.sic.Entities.Local;
import com.api.sic.Repository.LocalRepository;
import com.api.sic.Services.LocalService;

//import antlr.StringUtils;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/tp/locals")
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
/*	@PostMapping("/nouveau")
	public Local createLocal(@RequestParam("img") MultipartFile multipartFile, Local local) throws IOException {
		String FileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
		local.setPhoto(FileName);
		Local saveLocal =localRepository.save(local);
		String uploadDir="Documents/photo/"+saveLocal.getLocid()+"/";
		local.setPhotoDir(uploadDir+FileName);
//		String Type=multipartFile.getContentType();
		FileUpload.saveFile(uploadDir, FileName,multipartFile);
		return this.localRepository.save(local);
	}
*/
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")
	@RequestMapping("/{locid}")
	public Optional<Local> getLocal(@PathVariable int locid) {
		return localService.getLocal(locid);
		
	}*/
	//Récuperer un local par son id
@RequestMapping(value="/{locid}",method=RequestMethod.GET)
@CrossOrigin(origins = "*", allowedHeaders = "*")

public Optional<Local> getLocalById(@PathVariable("locid") int locid) {

    return localRepository.findById(locid);

}

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(method = RequestMethod.POST, value="/add")
public void addLocal(@RequestBody Local local) {
	
	localService.CreateLocal(local);
}
//Ajouter une maison
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PostMapping("/nouveau")
public  Local createLocal(@RequestBody Local local) {

    return localRepository.save(local);
}

//mettre à jour un local
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(method = RequestMethod.PUT, value="/{locid}")
public void updateLocal(@RequestBody Local local,@PathVariable int locid) {
	
	localService.updateLocal(locid, local);
}

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/locals/",method=RequestMethod.PUT)
public Local updateLocal(@RequestBody Local local) {

    return localRepository.save(local);

}
//suprimmer un local

//Suppression a parti de l'id
@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/delete/{locid}")
public void  deleteLocal(@PathVariable("locid") int locid) {

	localRepository.deleteById(locid);

}

}

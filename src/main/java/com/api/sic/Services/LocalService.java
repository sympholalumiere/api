package com.api.sic.Services;

import org.springframework.stereotype.Service;

import com.api.sic.Entities.Local;
import com.api.sic.Repository.LocalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class LocalService {
	@Autowired
	private LocalRepository localRepository;
	
	//service permettant de lister toutesles maisons 
	
	public List<Local> getAllLocals(){
		List<Local> locals= new ArrayList<>();
		localRepository.findAll().forEach(locals::add);
		return locals;
	}
	public Optional<Local> getLocal(int loca_id) {
		//return locals.stream().filter(c -> c.getId()==id).findFirst().get();
		return localRepository.findById(loca_id);
	}
	//service permettant d'ajouter un local dans le système
	
	public void CreateLocal(Local local) {
		localRepository.save(local);
}
	//service permettant de modifier un local dans le système
	
	public void updateLocal(int id, Local local) {
		/*for(int i=0;i<locals.size();i++) {
			Local c = locals.get(i);
			if(c.getId()==id) {
				locals.set(i, local);
				return;
			}
		}*/
		
		localRepository.save(local);
	}
	
	//service permettant de supprimer un local dans le système
	
	public void deleteLocal(int id) {
		//clients.removeIf(c -> c.getId()==id);
		localRepository.deleteById(id);
	}
	

}
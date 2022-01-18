package com.api.sic.Services;

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sic.Entities.User;
import com.api.sic.Repository.UserRepository;

@Service
*/
public class UserService {/*
	@Autowired
	private UserRepository userRepository;
	//service permettant de lister toutes les utilisateurs 
	public List<User> GetAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	//service permettant de lister un utilisateur 
	public Optional<User> getUser(int id) {
		//return users.stream().filter(c -> c.getId()==id).findFirst().get();
		return userRepository.findById(id);
	}
	//service permettant d'ajouter un utilisateur dans le système
	
	public void addUser(User user) {
		userRepository.save(user);
}
	//service permettant de modifier un utilisateur dans le système
	
	public void updateUser(int id, User user) {
		/*for(int i=0;i<users.size();i++) {
			Local c = users.get(i);
			if(c.getId()==id) {
				users.set(i, local);
				return;
			}
		}*//*
		
		userRepository.save(user);
	}
	
	//service permettant de supprimer un utilisateur dans le système
	
	public void deleteUser(int id) {
		//users.removeIf(c -> c.getId()==id);
		userRepository.deleteById(id);
	}
	*/
}

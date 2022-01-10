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

import com.api.sic.Entities.User;
import com.api.sic.Repository.UserRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/sic/users/")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@GetMapping(value = "all")
	public List<User>getAllUsers(){
	    List<User> saliste= new ArrayList<>();
	    userRepository.findAll().forEach(saliste::add);
		return saliste;
	} 
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public User getUserById(@PathVariable("id") int userId) {

	    return userRepository.findById(userId).get();

	}

@RequestMapping(value="/add/",method=RequestMethod.POST)
@CrossOrigin(origins = "http://localhost:4200")
public User createUser(@RequestBody User user) {

    return userRepository.save(user);
}

@RequestMapping(value="/users/",method=RequestMethod.PUT)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public User updateUser(@RequestBody User user,int id) {

    return userRepository.save(user);

}
@RequestMapping(value="/{id}",method=RequestMethod.DELETE)

@CrossOrigin(origins = "http://localhost:4200")
public void  deleteUser(@PathVariable("id") int userId) {

	userRepository.deleteById(userId);

}
}
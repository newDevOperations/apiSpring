package fr.api.rattrapage.controller;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.User;
import fr.api.rattrapage.repository.UserRepository;

@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	private UserRepository service;
		

	public String crypte(String password) throws GeneralSecurityException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();

	}

/*
	// RESTful API methods for Retrieval operations
	@GetMapping("/users")
	public List<User> list() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> get(@PathVariable Integer id) {
		return service.findById(id);
	}

*/
		
		
	// VERIFIE USERNAME ET PASSWORD et renvoie true si ok sinon false 
	@GetMapping("/user/{username}/{password}")
	public boolean verifie(@PathVariable String username, @PathVariable String password) throws GeneralSecurityException {
		boolean trouve = false;
		List <User> users = service.findAll();
		for (User c : users) {
			if (c.getUsername().equals(username) && c.getPassword().equals(crypte(password))) {
				trouve = true;
			}
		}
		
		return trouve;
	}
	
	

	// RESTful API method for Create operation
	@PostMapping("/users")
	public void add(@RequestBody User user) {
		service.save(user);
	}

	// RESTful API method for Update operation
	@PutMapping("/users/{id}")
	public void update(@RequestBody User user, @PathVariable Integer id) {
		User existUser = service.findById(id).get();
		service.save(existUser);
	}

	// RESTful API method for Delete operation
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteById(id);
	}
}

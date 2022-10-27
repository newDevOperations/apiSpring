package fr.api.rattrapage.controller;

import java.security.GeneralSecurityException;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Surveillant;
import fr.api.rattrapage.repository.SurveillantRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class SurveillantController {
 
    @Autowired
    private SurveillantRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/surveillants")
    public List<Surveillant> list() {
        return service.findAll();
    }
    
   @GetMapping("/surveillants/{id}")
    public Optional<Surveillant> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
   @GetMapping("/surveillant/{username}")
	public Surveillant getSurveillantByUsername(@PathVariable String username) throws GeneralSecurityException {
		List <Surveillant> surveillants = service.findAll();
		for (Surveillant c : surveillants) {
			if (c.getCourriel().equals(username)) {
				return c;
			}
		}
		
		return null;
	}
   
    // RESTful API method for Create operation
    @PostMapping("/surveillants")
    public void add(@RequestBody Surveillant surveillant) {
    	service.save(surveillant);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/surveillants/{id}")
    public void update(@RequestBody Surveillant surveillant, @PathVariable Integer id) {
    	Surveillant existSurveillant = service.findById(id).get();
    	service.save(existSurveillant);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/surveillants/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


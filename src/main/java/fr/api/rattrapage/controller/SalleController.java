package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Salle;
import fr.api.rattrapage.repository.SalleRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class SalleController {
 
    @Autowired
    private SalleRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/salles")
    public List<Salle> list() {
        return service.findAll();
    }
    
   @GetMapping("/salles/{id}")
    public Optional<Salle> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/salles")
    public void add(@RequestBody Salle salle) {
    	service.save(salle);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/salles/{id}")
    public void update(@RequestBody Salle salle, @PathVariable Integer id) {
    	Salle existSalle = service.findById(id).get();
    	service.save(existSalle);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/salles/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Apprenant;
import fr.api.rattrapage.repository.ApprenantRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class ApprenantController {
 
    @Autowired
    private ApprenantRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/apprenants")
    public List<Apprenant> list() {
        return service.findAll();
    }
    
   @GetMapping("/apprenants/{id}")
    public Optional<Apprenant> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/apprenants")
    public void add(@RequestBody Apprenant apprenant) {
    	service.save(apprenant);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/apprenants/{id}")
    public void update(@RequestBody Apprenant apprenant, @PathVariable Integer id) {
    	Apprenant existApprenant = service.findById(id).get();
    	service.save(existApprenant);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/apprenants/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


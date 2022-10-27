package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Departement;
import fr.api.rattrapage.repository.DepartementRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class DepartementController {
 
    @Autowired
    private DepartementRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/departements")
    public List<Departement> list() {
        return service.findAll();
    }
    
   @GetMapping("/departements/{id}")
    public Optional<Departement> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/departements")
    public void add(@RequestBody Departement departement) {
    	service.save(departement);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/departements/{id}")
    public void update(@RequestBody Departement departement, @PathVariable Integer id) {
    	Departement existDepartement = service.findById(id).get();
        service.save(existDepartement);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/departements/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


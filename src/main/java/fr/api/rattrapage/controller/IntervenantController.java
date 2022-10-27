package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Intervenant;
import fr.api.rattrapage.repository.IntervenantRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class IntervenantController {
 
    @Autowired
    private IntervenantRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/intervenants")
    public List<Intervenant> list() {
        return service.findAll();
    }
    
   @GetMapping("/intervenants/{id}")
    public Optional<Intervenant> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/intervenants")
    public void add(@RequestBody Intervenant intervenant) {
    	service.save(intervenant);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/intervenants/{id}")
    public void update(@RequestBody Intervenant intervenant, @PathVariable Integer id) {
    	Intervenant existIntervenant = service.findById(id).get();
    	service.save(existIntervenant);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/intervenants/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


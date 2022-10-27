package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Matiere;
import fr.api.rattrapage.repository.MatiereRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class MatiereController {
 
    @Autowired
    private MatiereRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/matieres")
    public List<Matiere> list() {
        return service.findAll();
    }
    
   @GetMapping("/matieres/{id}")
    public Optional<Matiere> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/matieres")
    public void add(@RequestBody Matiere matiere) {
    	service.save(matiere);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/matieres/{id}")
    public void update(@RequestBody Matiere matiere, @PathVariable Integer id) {
    	Matiere existMatiere = service.findById(id).get();
    	service.save(existMatiere);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/matieres/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


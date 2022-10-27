package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Responsable;
import fr.api.rattrapage.repository.ResponsableRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class ResponsableController {
 
    @Autowired
    private ResponsableRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/responsables")
    public List<Responsable> list() {
        return service.findAll();
    }
    
   @GetMapping("/responsables/{id}")
    public Optional<Responsable> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/responsables")
    public void add(@RequestBody Responsable responsable) {
    	service.save(responsable);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/responsables/{id}")
    public void update(@RequestBody Responsable responsable, @PathVariable Integer id) {
    	Responsable existResponsable = service.findById(id).get();
    	service.save(existResponsable);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/responsables/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}

	
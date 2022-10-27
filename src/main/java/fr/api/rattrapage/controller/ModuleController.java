package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Module;
import fr.api.rattrapage.repository.ModuleRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class ModuleController {
 
    @Autowired
    private ModuleRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/modules")
    public List<Module> list() {
        return service.findAll();
    }
    
   @GetMapping("/modules/{id}")
    public Optional<Module> get(@PathVariable Integer id) {
       return service.findById(id);
    }
     
    // RESTful API method for Create operation
    @PostMapping("/modules")
    public void add(@RequestBody Module module) {
    	service.save(module);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/modules/{id}")
    public void update(@RequestBody Module module, @PathVariable Integer id) {
    	Module existModule = service.findById(id).get();
    	service.save(existModule);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/modules/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


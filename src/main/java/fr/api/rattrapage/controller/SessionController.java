package fr.api.rattrapage.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Session;
import fr.api.rattrapage.repository.SessionRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class SessionController {
 
    @Autowired
    private SessionRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/sessions")
    public List<Session> list() {
        return service.findAll();
    }
    
   @GetMapping("/sessions/{id}")
    public Optional<Session> get(@PathVariable Integer id) {
       return service.findById(id);
    }
   
   @GetMapping("/sessions/surveillant/{idSurveillant}")
   public  List<Session> getSessionsByIdSurveillant(@PathVariable int idSurveillant){
	   List<Session> sessions = service.findAll();
       List<Session> filtreSessions = new ArrayList<>();
       for (Session c: sessions) {
           if(c.getSurveillant().getIdSurveillant() == idSurveillant){
           	filtreSessions.add(c);
           }
       }
        return filtreSessions;
   }
         
    // RESTful API method for Create operation
    @PostMapping("/sessions")
    public void add(@RequestBody Session session) {
    	service.save(session);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/sessions/{id}")
    public void update(@RequestBody Session session, @PathVariable Integer id) {
    	Session existSession = service.findById(id).get();
    	service.save(existSession);
    }
     
    // RESTful API method for Delete operation
    @DeleteMapping("/sessions/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


package fr.api.rattrapage.controller;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import fr.api.rattrapage.entity.Inscription;
import fr.api.rattrapage.entity.InscriptionKey;
import fr.api.rattrapage.repository.InscriptionRepository;
 
@CrossOrigin(origins = "Http://localhost:4200")
@RestController
public class InscriptionController {
 
    @Autowired
    private InscriptionRepository service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/inscriptions")
    public List<Inscription> list() {
        return service.findAll();
    }
    
    
    @GetMapping("/inscriptions/{idSession}")
    public List<Inscription> getApprenantBisByIdSession(@PathVariable int idSession){
    	List<Inscription> inscriptions = service.findAll();
    	List<Inscription> cible = new ArrayList<>();
        for (Inscription c: inscriptions) {
            if(c.getId().getIdSession() == idSession){
            	cible.add(c);
            }
        }
        return cible;
    }
    
    //Enregistre emmargement et timestamp et retourne timestamp si emmargement true sinon retourne 1
    @PatchMapping("/session/{idSession}/apprenant/{idApprenant}")
    public Long setPresentEleve(@PathVariable int idSession, @PathVariable int idApprenant){
    	InscriptionKey key = new InscriptionKey(idSession, idApprenant);
        Inscription c =  service.findById(key).get();
        long timeServer = 1;
       	c.setEmmargement(!c.isEmmargement());
       	if (c.isEmmargement()) {
       		timeServer = new Timestamp(System.currentTimeMillis()).getTime();
        }
        
       	c.setDateFin(timeServer);
        service.save(c);
      
        return timeServer;
    }
  
  //Enregistre note de l'élève
    @PatchMapping("/session/{idSession}/apprenant/{idApprenant}/note")
    public int setNoteEleve(@PathVariable int idSession, @PathVariable int idApprenant, @RequestBody int note){
       	InscriptionKey key = new InscriptionKey(idSession, idApprenant);
        Inscription c =  service.findById(key).get();
        c.setNote(note);
       	service.save(c);
       	return note;      
    }
    
    
    // RESTful API method for Create operation
    @PostMapping("/inscriptions")
    public void add(@RequestBody Inscription inscription) {
    	service.save(inscription);
    }
 }


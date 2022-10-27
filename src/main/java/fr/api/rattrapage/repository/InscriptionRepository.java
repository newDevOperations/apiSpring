package fr.api.rattrapage.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import fr.api.rattrapage.entity.Inscription;
import fr.api.rattrapage.entity.InscriptionKey;

public interface InscriptionRepository extends JpaRepository<Inscription, InscriptionKey>{
	
}
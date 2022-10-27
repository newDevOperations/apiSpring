package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Intervenant;

public interface IntervenantRepository extends JpaRepository<Intervenant, Integer> {
 
}

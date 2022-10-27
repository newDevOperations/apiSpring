package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Surveillant;

public interface SurveillantRepository extends JpaRepository<Surveillant, Integer> {
 
}

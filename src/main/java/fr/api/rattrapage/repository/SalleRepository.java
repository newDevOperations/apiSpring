package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Salle;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
 
}

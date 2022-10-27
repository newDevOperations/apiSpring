package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

}
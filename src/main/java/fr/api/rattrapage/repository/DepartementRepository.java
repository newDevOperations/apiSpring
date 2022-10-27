package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	
}
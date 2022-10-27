package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
 
}

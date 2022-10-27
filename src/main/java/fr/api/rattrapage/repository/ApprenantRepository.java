package fr.api.rattrapage.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant, Integer> {

}
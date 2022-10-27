package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Module;

public interface ModuleRepository extends JpaRepository<Module, Integer> {

}
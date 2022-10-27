package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}
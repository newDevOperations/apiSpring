package fr.api.rattrapage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.api.rattrapage.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
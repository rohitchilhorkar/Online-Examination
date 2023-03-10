package com.pratiti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratiti.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Optional<User> findByEmail(String email);
	
	public boolean existsByEmail(String email);
	
	public Optional<User> findByEmailAndPassword(String email , String password);
	
	
	

}
package com.pratiti.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pratiti.entity.Scorecard;


@Repository
public interface ScorecardRepository extends JpaRepository<Scorecard, Integer> {
	
	@Query("SELECT q FROM Scorecard q WHERE q.student.userId=?1")
	public Optional<Scorecard> findByStudentId(int id);
}
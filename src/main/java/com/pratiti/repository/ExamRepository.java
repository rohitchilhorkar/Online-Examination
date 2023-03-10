package com.pratiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratiti.entity.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

	
}
package com.pratiti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pratiti.entity.QuestionOption;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Integer> {
	
	@Modifying
	@Query("update QuestionOption q set q.Status=?1 where q.subject.subjectId=?2")
	void updateBysubjectId(String status , Integer subjectId);
}

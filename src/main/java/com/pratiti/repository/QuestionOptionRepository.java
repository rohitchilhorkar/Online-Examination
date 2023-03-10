package com.pratiti.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pratiti.entity.QuestionOption;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Integer> {

	public Optional<QuestionOption> findById(Integer id);

	@Query("SELECT q FROM QuestionOption q WHERE q.subject.subjectName=?1 and q.questionLevel=?2 and q.Status=?3")
	public List<QuestionOption> findBySubjectName(String subjectName, int level,String status);
	
	
	@Modifying
	@Query("update QuestionOption q set q.Status=?1 where q.subject.subjectId=?2")
	void updateBysubjectId(String status , Integer subjectId);
}

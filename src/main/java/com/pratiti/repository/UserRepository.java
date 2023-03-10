package com.pratiti.repository;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
=======
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
>>>>>>> c72b831c4ceea394d03fb0192d02c65241ff3f36


import com.pratiti.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
<<<<<<< HEAD
	public Optional<User> findByEmail(String email);
	
	public boolean existsByEmail(String email);
	
	public Optional<User> findByEmailAndPassword(String email , String password);
	
	
	

}
=======
//	@Query("select u from Scorecard s join s.student u where s.subject.name =?1 and s.level1Score =?2")
//	List<User> fetchByNameAndLevelAndLevelScore(String subjectName, Integer levelScore);
	
	@Query("SELECT u FROM Scorecard s JOIN s.student u WHERE s.subject.subjectName = ?1 AND s.level1Score = ?2")
	List<User> fetchByNameAndLevelAndLevel1Score(String subjectName, Integer levelScore);
	
	@Query("SELECT u FROM Scorecard s JOIN s.student u WHERE s.subject.subjectName = ?1 AND s.level2Score = ?2")
	List<User> fetchByNameAndLevelAndLevel2Score(String subjectName, Integer levelScore);
	
	@Query("SELECT u FROM Scorecard s JOIN s.student u WHERE s.subject.subjectName = ?1 AND s.level3Score = ?2")
	List<User> fetchByNameAndLevelAndLevel3Score(String subjectName, Integer levelScore);
	
//	@Query("select u from Scorecard s join s.student u where s.subject.name =?1 s.level1score =?2")
//	public Optional<User> fetchUserData(String subjectName , Integer score);
}



>>>>>>> c72b831c4ceea394d03fb0192d02c65241ff3f36

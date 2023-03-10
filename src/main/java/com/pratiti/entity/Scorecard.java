package com.pratiti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Scorecard")
public class Scorecard {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scorecardId;
    
    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "userId")
    private User student;
    
    @ManyToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId")
    private Subject subject;
    
    private Integer level1Score;
    private Integer level2Score;
    private Integer level3Score;
	public Integer getScorecardId() {
		return scorecardId;
	}
	public void setScorecardId(Integer scorecardId) {
		this.scorecardId = scorecardId;
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Integer getLevel1Score() {
		return level1Score;
	}
	public void setLevel1Score(Integer level1Score) {
		this.level1Score = level1Score;
	}
	public Integer getLevel2Score() {
		return level2Score;
	}
	public void setLevel2Score(Integer level2Score) {
		this.level2Score = level2Score;
	}
	public Integer getLevel3Score() {
		return level3Score;
	}
	public void setLevel3Score(Integer level3Score) {
		this.level3Score = level3Score;
	}
    
    
    
    
}

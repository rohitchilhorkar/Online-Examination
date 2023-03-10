package com.pratiti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pratiti.entity.QuestionOption;
import com.pratiti.entity.Scorecard;
import com.pratiti.entity.Subject;
import com.pratiti.model.QuestionDto;
import com.pratiti.model.SubjectDto;
import com.pratiti.repository.QuestionOptionRepository;
import com.pratiti.repository.ScorecardRepository;
import com.pratiti.repository.ScorecardRepository;
import com.pratiti.repository.SubjectRepository;

@Service
public class OnlineExamService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private QuestionOptionRepository questionOptionRepository;
	@Autowired
	private ScorecardRepository scorecardRepository;


	public String addSubjectWithQuestionsAndOptions(SubjectDto subjectDto) {

		Subject subject = new Subject();
		subject.setSubjectName(subjectDto.getSubjectName());
		subject.setSubjectNoOfQuestions(subjectDto.getSubjectNoOfQuestions());
		
		List<QuestionOption> questionOptions = new ArrayList<>();
		for (QuestionDto questionDto : subjectDto.getQuestions()) {
			QuestionOption questionOption = new QuestionOption();
			questionOption.setQuestionDesc(questionDto.getQuestionDesc());
			questionOption.setQuestionLevel(questionDto.getQuestionLevel());
			questionOption.setOption1(questionDto.getOption1());
			questionOption.setOption2(questionDto.getOption2());
			questionOption.setOption3(questionDto.getOption3());
			questionOption.setOption4(questionDto.getOption4());
			questionOption.setIsCorrect(questionDto.getIsCorrect());
			questionOption.setSubject(subject);
			questionOptions.add(questionOption);
		 }
		 
		 questionOptionRepository.saveAll(questionOptions);
		 subjectRepository.save(subject);
	 
		 return "Subject with questions and options added successfully";

	 }
	
	public List<QuestionOption> displayQuestions() {
		
//		For Testing Purpose
//		List<QuestionOption> questions = new ArrayList<>();
//		questions = questionOptionRepository.findAll();
//		for (QuestionOption question : questions) {
//			System.out.println(question.getQuestionDesc());
//			System.out.println(question.getOption1());
//		 }
		
		return questionOptionRepository.findAll();
	}

	
	public List<QuestionOption> displayQuestionOfParticularSubject(String subjectName, int level) {
		
		
		//Optional<Subject> s = subjectRepository.findBySubjectName(subjectName);
		//System.out.println(s.get().getSubjectId());
		List<QuestionOption> ques = questionOptionRepository.findBySubjectName(subjectName, level,"active");
		
		
////		Subject subject1 = s.get();
////		System.out.println(subject1.getSubjectId());
//		Optional<Subject> subject = subjectRepository.findBySubjectName(subjectName);
//		System.out.println(subject.get().getSubjectId());
//		ArrayList<QuestionOption> result = new ArrayList<>();
//		ques.ifPresent(result :: add);
//		for (QuestionOption questionDto : result) {
//			System.out.println(questionDto.getQuestionDesc());
//		 }		
		return ques;
	}

	public Scorecard displayScoreWithId(int id) {
		// TODO Auto-generated method stub
		Scorecard score = scorecardRepository.findByStudentId(id).get();
		return score;
	}
}

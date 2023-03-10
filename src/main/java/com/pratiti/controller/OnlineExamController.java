package com.pratiti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pratiti.entity.QuestionOption;
import com.pratiti.entity.Scorecard;
import com.pratiti.entity.Subject;
import com.pratiti.model.QuestionDto;
import com.pratiti.model.SubjectDto;
import com.pratiti.model.levelsScore;
import com.pratiti.repository.QuestionOptionRepository;
import com.pratiti.repository.SubjectRepository;
import com.pratiti.service.OnlineExamService;

@RestController
@CrossOrigin
public class OnlineExamController {
	
	@Autowired
	private OnlineExamService onlineExamService;

	@PostMapping(path="/addSubjectWithQuestionsAndOptions")
	public String addSubjectWithQuestionsAndOptions(@RequestBody SubjectDto subjectDto) {
		//System.out.println(subjectDto);
		//return "";
		return onlineExamService.addSubjectWithQuestionsAndOptions(subjectDto);
	}
		
	@GetMapping(path="/displayQuestions")
	public List<QuestionOption> displayAllQuestions(){
		return onlineExamService.displayQuestions();
	}
	
	@GetMapping(path="/displayScoreWithId")
	public levelsScore displayScoreWithId(@RequestParam("id") Integer id){
		Scorecard s = onlineExamService.displayScoreWithId(id);
		levelsScore l = new levelsScore();
		l.setLevel1Score(s.getLevel1Score());
		l.setLevel2Score(s.getLevel2Score());
		l.setLevel3Score(s.getLevel3Score());
		return l;
	}
	
	@GetMapping(path="/displayQuestionOfParticularSubject")
	public List<QuestionOption> displayQuestionsOfSubject(String subjectName,int level){
		return onlineExamService.displayQuestionOfParticularSubject(subjectName, level);
	}
	
}

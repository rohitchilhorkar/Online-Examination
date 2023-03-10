package com.pratiti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.pratiti.entity.QuestionOption;
import com.pratiti.entity.Scorecard;
import com.pratiti.entity.Subject;
import com.pratiti.entity.User;
import com.pratiti.exception.CustomerServiceException;
import com.pratiti.model.QuestionDto;
import com.pratiti.model.SubjectDto;
import com.pratiti.model.levelsScore;
import com.pratiti.model.UserParameter;
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
	
	
	@GetMapping(path="/setSelectedOption")
	public String setSelectedOption(@RequestParam("qId") Integer qId, @RequestParam("uId") Integer uId, @RequestParam("selectedOption") Integer selectedOption) {
		onlineExamService.setOption(uId, qId, selectedOption);
		return "Updated Answer Successfully";
	}
	@GetMapping(path="/setScoreWithId")
	public String setScoreWithId(@RequestParam("uId") Integer uId,@RequestParam("sId") Integer sId, @RequestParam("score") Integer score, @RequestParam("level") Integer level) {
		onlineExamService.setScore(uId, sId, score, level);
		return "Updated Score Successfully";
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
	
	@GetMapping("/remove-subject")
	public String removeSubject(@RequestParam("subjectName") String subjectName) {
		return onlineExamService.removeSubject(subjectName);
	}
	

	
//	@GetMapping("/fetch-user")
//	public String fetchUser(@RequestBody UserParameter userParameter) {
//		return onlineExamService.fetchUser(userParameter);
//	}
	
	@GetMapping("/subject/{subjectName}/level/{level}/score/{levelScore}")
    public List<User> getUsersBySubjectAndScore(@PathVariable String subjectName, @PathVariable Integer level , @PathVariable Integer levelScore) {
        return onlineExamService.getUsersBySubjectAndScore(subjectName, level , levelScore);
    }
}

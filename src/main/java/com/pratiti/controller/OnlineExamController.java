package com.pratiti.controller;

import java.util.ArrayList;
import java.util.List;

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
		return onlineExamService.addSubjectWithQuestionsAndOptions(subjectDto);
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

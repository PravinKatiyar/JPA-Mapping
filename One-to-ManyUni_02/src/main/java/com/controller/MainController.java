package com.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Answer;
import com.entity.Question;
import com.service.ServiceImpl;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(value = "*")
public class MainController {
	@Autowired
	private ServiceImpl service;
	
	private final org.slf4j.Logger l=LoggerFactory.getLogger(this.getClass().getName());
	
	// Add question
	@PostMapping("/question")
	public Question createStudent(@RequestBody Question question) {  
		return service.addQuestion(question);
	}
	
	@GetMapping("/question")
	public List<Question> getAllQuestions() {
		l.info("inside getAllQuestions");
		return service.getAllQuestions();
	}
	
	@GetMapping("/question/{questionId}")
	public Question getQuestion(@PathVariable("questionId") Integer questionId) {
		return service.getQuestion(questionId);
	}
	
	@GetMapping("/questionOnly/{questionId}")
	public Question getQuestionOnly(@PathVariable("questionId") Integer questionId) {
		return service.getQuestionOnly(questionId);
	}
	
	@GetMapping("/answer")
	public List<Answer> getAllanswers() {
		return service.getAllAnswers();
	}
	
	@PostMapping("/ques/{quesId}/answer")
	public Answer addAnswer(@PathVariable Integer quesId, @RequestBody Answer ans) {
		return service.addAnswer(quesId, ans);
	}

}

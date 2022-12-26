package com.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.AnswerDaoImpl;
import com.dao.QuestionDaoImpl;
import com.entity.Answer;
import com.entity.Question;

@Service
public class ServiceImpl {

	@Autowired
	private QuestionDaoImpl quesdao;

	@Autowired
	private AnswerDaoImpl ansdao;

	public Question addQuestion(Question question) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		question.setDateTimeCreated(dtf.format(now));
		return quesdao.save(question);
	}

	public List<Question> getAllQuestions() {
		return quesdao.findAll();
	}

	public Answer addAnswer(Integer questionId, Answer answer) {	 
		
		//fetch question from database
		Optional<Question> dbQuestion=quesdao.findById(questionId);
		if (!dbQuestion.isPresent()) {
            throw new QuestionNotFoundException("Question not found!");
        }
		Question question=dbQuestion.get();
		
		//saving answer to db
		Answer answerObj=ansdao.save(answer);
		
		//answerList.addAll(question.getAnswers());
		
		question.getAnswers().add(answerObj);
		question.setAnswers(question.getAnswers());
		quesdao.save(question);
		return answerObj;
	 }

	public List<Answer> getAllAnswers() {
		return ansdao.findAll();
	}

	public Question getQuestion(Integer questionId) {
		////fetch question from database
		Optional<Question> byId = quesdao.findById(questionId);
		if (!byId.isPresent()) {
			throw new QuestionNotFoundException("Question not found!");
		}

		// Assign Db data to question
		Question question = byId.get();
		return question;
	}

	public Question getQuestionOnly(Integer questionId) {
		Optional<Question> byId = quesdao.findById(questionId);
		if (!byId.isPresent()) {
			throw new QuestionNotFoundException("Question not found!");
		}
		Question question = byId.get();
		//use dto class to map the entity to dto
		return question;
	}

}

package org.matrix.question.controller;

import java.util.Collection;

import org.matrix.question.model.Option;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class QuestionManageController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/questions", method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(@RequestBody Question aQuestion) {
		System.out.println("QuestionManageController.addQuestion() : " + aQuestion.getQuestionText());

		for (Option anOption : aQuestion.getOptions()) {
			System.out.println("QuestionManageController.addQuestion() : option => " + anOption.getOptionText()
					+ " Correct ? => " + anOption.isCorrect());
		}

		questionService.addQuestion(aQuestion);

		return new ResponseEntity<Question>(aQuestion, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/questions", method = RequestMethod.PUT)
	public ResponseEntity<Question> updateQuestion(@RequestBody Question aQuestion) {
		System.out.println("QuestionManageController.updateQuestion() : " + aQuestion.getQuestionText());

		for (Option anOption : aQuestion.getOptions()) {
			System.out.println("QuestionManageController.updateQuestion() : option => " + anOption.getOptionText()
					+ " Correct ? => " + anOption.isCorrect());
		}

		questionService.updateQuestion(aQuestion);

		return new ResponseEntity<Question>(aQuestion, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public Collection<Question> getAllQuestions() {
		Collection<Question> questions = this.questionService.getAllQuestions();
		System.out.println("QuestionManageController.getAllQuestions() : size = " + questions.size());
		return questions;

	}

	@RequestMapping(value = "/questions/{Id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Question getQuestionById(@PathVariable("Id") Long Id) {
		Question retrivedQ = questionService.getQuestion(Id.longValue());
		System.out.println("QuestionManageController.getQuestionById() : " + retrivedQ.getQuestionId() + " - "
				+ retrivedQ.getQuestionText());
		return retrivedQ;
	}

}

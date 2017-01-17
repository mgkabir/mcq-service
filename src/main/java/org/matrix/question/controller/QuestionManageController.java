package org.matrix.question.controller;

import org.matrix.question.model.Option;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController

public class QuestionManageController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(@RequestBody Question aQuestion) {
		System.out.println("QuestionManageController.addQuestion() : " + aQuestion.getQuestionText());

		for (Option anOption : aQuestion.getOptions()) {
			System.out.println("QuestionManageController.addQuestion() : " + anOption.getOptionText());
		}

		questionService.addQuestion(aQuestion);

		return new ResponseEntity<Question>(aQuestion,HttpStatus.CREATED);
	}
}

package org.matrix.question.controller;

import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value="/{Id}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Question getQuestionById(@PathVariable("Id") Long Id) {
		System.out.println("Controller.getQuestionById() : Id"+Id);
		Question retrivedQ = questionService.getQuestion(Id.longValue());
		return retrivedQ;
	}
}

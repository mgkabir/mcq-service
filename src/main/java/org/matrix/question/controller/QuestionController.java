package org.matrix.question.controller;

import org.matrix.question.model.Answer;
import org.matrix.question.model.Option;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/{Id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Question getQuestionById(@PathVariable("Id") Long Id) {
		Question retrivedQ = questionService.getQuestion(Id.longValue());
		System.out.println("QuestionController.getQuestionById() : " + retrivedQ.getQuestionId() + " - "
				+ retrivedQ.getQuestionText());
		return retrivedQ;
	}

	@RequestMapping(value = "/{questionId}/option/{optionId}", method = RequestMethod.POST)
	public ResponseEntity<Answer> answerQuestion(@PathVariable("questionId") Long questionId,
			@PathVariable("optionId") Long optionId) {

		Answer answer = new Answer();
		Question retrivedQ = questionService.getQuestion(questionId.longValue());
		answer.setCurrentQuestion(retrivedQ);
		answer.setNextQuestionId(getNextQuestionId(retrivedQ.getQuestionId()));

		for (Option anOption : retrivedQ.getOptions()) {
			if (optionId == anOption.getOptionId()) {
				answer.setCorrect(anOption.isCorrect());
			}
		}
		System.out.println("QuestionController.answerQuestion() => Correct ? " + answer.isCorrect());
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}

	/* Implementation will change */
	private long getNextQuestionId(long currentQuestionId) {

		long nextQuestionId = 1;
		if (currentQuestionId < 5) {
			nextQuestionId += currentQuestionId;
		}
		return nextQuestionId;
	}
}

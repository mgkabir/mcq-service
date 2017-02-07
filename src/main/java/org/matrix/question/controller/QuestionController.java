package org.matrix.question.controller;

import org.matrix.question.model.Answer;
import org.matrix.question.model.Option;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.matrix.utils.QuestionUtils;
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

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Question getRandomQuestion() {
		Question retrivedQ = QuestionUtils.getRandomQuestion(questionService);
		System.out.println("QuestionController.getQuestionById() : " + retrivedQ.getQuestionId() + " - "
				+ retrivedQ.getQuestionText());
		return retrivedQ;
	}

	@RequestMapping(value = "/{questionId}/option/{optionId}", method = RequestMethod.POST)
	public ResponseEntity<Answer> answerQuestion(@PathVariable("questionId") Long questionId,
			@PathVariable("optionId") Long optionId) {

		System.out.println("QuestionController.answerQuestion() QID - OptID: " + questionId + " - "
				+ optionId);
		
		Answer answer = new Answer();
		Question retrivedQ = questionService.getQuestion(questionId.longValue());
		answer.setCurrentQuestion(retrivedQ);

		retrivedQ.getOptions().forEach(opt -> {
			if (optionId == opt.getOptionId()) {
				answer.setCorrect(opt.isCorrect());
			}
		});

		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}

}

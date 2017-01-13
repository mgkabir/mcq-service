package org.matrix.question.controller;

import org.matrix.question.model.Answer;
import org.matrix.question.model.Option;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

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
		return retrivedQ;
	}

	@RequestMapping(value = "/{questionId}/option/{optionId}", method = RequestMethod.POST)
	public ResponseEntity<Answer> answerQuestion(@PathVariable("questionId") Long questionId,
			@PathVariable("optionId") Long optionId) {
		
		Answer answer = new Answer();
		Question retrivedQ = questionService.getQuestion(questionId.longValue());
		answer.setCurrentQuestion(retrivedQ);
		answer.setNextQuestion(this.nextQuestion(retrivedQ));

		for (Option anOption : retrivedQ.getOptions()) {
			if (optionId == anOption.getOptionId()) {
				answer.setCorrect(anOption.isCorrect());
			}
		}
		System.out.println("QuestionController.answerQuestion() => Correct ? "+answer.isCorrect());
		return new ResponseEntity<Answer>(answer, HttpStatus.OK);
	}

	/* Implementation will change*/
	private Question nextQuestion(Question currentQuestion){
		
		long nextQuestionId = 1;
		if(currentQuestion.getQuestionId() < 3){
			nextQuestionId += currentQuestion.getQuestionId().longValue();
		}
		return questionService.getQuestion(nextQuestionId);
	}
}

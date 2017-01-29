package org.matrix.utils;

import java.util.Random;

import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;

public class QuestionUtils {

	public static Question getRandomQuestion(QuestionService qService) {
		Random r = new Random();
		long randomId = r.longs(1, getQuestionCount(qService)).limit(1).findFirst().getAsLong();
		System.out.println("QuestionUtils.getRandomQuestion : Random ID = > " + randomId);
		return qService.getQuestion(randomId);
	}

	private static long getQuestionCount(QuestionService qService) {
		long totalQuestion = qService.getQuestionCount();
		System.out.println("QuestionUtils.getQuestionCount() : Total Question => " + totalQuestion);
		return totalQuestion;
	}

}

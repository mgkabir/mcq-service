package org.matrix.utils;

import java.util.Random;
import org.matrix.question.model.Question;
import org.matrix.question.service.QuestionService;

public class QuestionUtils {

	public static Question getRandomQuestion(QuestionService qService) {
		Random r = new Random();
		long randomId = r.ints(1, 20).limit(1).findFirst().getAsInt();
		System.out.println("QuestionUtils.getRandomQuestion : ID = > " + randomId);
		return qService.getQuestion(randomId);
	}

}

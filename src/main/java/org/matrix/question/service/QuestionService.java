package org.matrix.question.service;

import org.matrix.question.model.Question;

public interface QuestionService {

	public Question getQuestion(long Id);

	public void addQuestion(Question aQuestion);

}

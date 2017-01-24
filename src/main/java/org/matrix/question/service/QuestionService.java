package org.matrix.question.service;

import java.util.Collection;

import org.matrix.question.model.Question;

public interface QuestionService {

	public Question getQuestion(long Id);

	public void addQuestion(Question aQuestion);

	public void updateQuestion(Question aQuestion);

	public Collection<Question> getAllQuestions();

}

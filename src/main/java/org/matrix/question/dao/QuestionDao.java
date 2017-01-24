package org.matrix.question.dao;

import java.util.Collection;

import org.matrix.question.model.Question;

public interface QuestionDao {

	public Question getQuestion(long Id);

	public void addQuestion(Question aQuestion);

	public Collection<Question> getAllQuestions();

	public void updateQuestion(Question aQuestion);
}

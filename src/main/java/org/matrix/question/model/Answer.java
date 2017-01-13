package org.matrix.question.model;

public class Answer {
	
	private Question currentQuestion ;
	private Question nextQuestion;
	private boolean isCorrect;
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public Question getNextQuestion() {
		return nextQuestion;
	}
	public void setNextQuestion(Question nextQuestion) {
		this.nextQuestion = nextQuestion;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}

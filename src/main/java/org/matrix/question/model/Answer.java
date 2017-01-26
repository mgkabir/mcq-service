package org.matrix.question.model;

public class Answer {

	private Question currentQuestion;
	private long nextQuestionId; // can be removed ?
	private boolean isCorrect;

	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public long getNextQuestionId() {
		return nextQuestionId;
	}

	public void setNextQuestionId(long nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}

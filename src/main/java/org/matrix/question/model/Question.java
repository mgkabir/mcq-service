package org.matrix.question.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTIONS")
public class Question {

	@Id
	@GeneratedValue
	@Column(name="QUESTION_ID")
	private Long questionId;
	
	@Column(name="QUESTION_TEXT")
	private String questionText;
	
	@Column(name="ANSWER_TEXT")
	private String answerText; // Explanation of Answer. Why a specific option is correct or not.
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "ANSWER_OPTIONS", joinColumns=@JoinColumn(name="QUESTION_ID"))
	private Set<Option> options = new HashSet<Option>(); 
	
		
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
}

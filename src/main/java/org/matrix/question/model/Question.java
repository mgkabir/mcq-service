package org.matrix.question.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue
	private Long questionId;
	private String questionText;
	
	@ElementCollection
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

}

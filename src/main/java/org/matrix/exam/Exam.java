package org.matrix.exam;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.matrix.question.model.Question;

/**
 * Model exam for the students.
 * 
 * @author Mohammad Kabir
 *
 */
@Entity(name = "EXAMS")
public class Exam {

	@Id
	@GeneratedValue
	@Column(name = "EXAM_ID")
	private Long examId;

	@Column(name = "EXAM_TITLE", length=500)
	private String title;

	@Column(name = "FULL_SCORE")
	private Float fullScore; 
	
	/* Highest score achieved so far. Will be updated for every completed exam.*/
	@Column(name="HIGHEST_SCORE") 
	private Float highestScore;
	
	/* averageScore will be updated after every exam completion. */
	@Column(name="AVERAGE_SCORE")
	private Float averageScore; 
	
	@ManyToMany
	@JoinTable(name = "EXAM_QUESTION", joinColumns = @JoinColumn(name = "EXAM_ID"), inverseJoinColumns = @JoinColumn(name = "QUESTION_ID"))
	private Set<Question> questions;

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getFullScore() {
		return fullScore;
	}

	public void setFullScore(Float fullScore) {
		this.fullScore = fullScore;
	}

	public Float getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(Float highestScore) {
		this.highestScore = highestScore;
	}

	public Float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Float averageScore) {
		this.averageScore = averageScore;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}	
}

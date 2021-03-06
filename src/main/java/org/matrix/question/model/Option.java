package org.matrix.question.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Option {
	
	@Column(name="OPTION_ID")
	private Long optionId;
	@Column(name="OPTION_TEXT")
	private String optionText;
	@Column(name="IS_CORRECT")
	private boolean isCorrect;
	
	public Long getOptionId() {
		return optionId;
	}
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	

}

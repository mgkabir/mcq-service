package org.matrix.question.model;

import javax.persistence.Embeddable;

@Embeddable
public class Option {
	
	private Long optionId;
	private String optionText;
	private boolean isCorrect;
	private String reason; // Reason why this option is correct / incorrect.
	
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	

}

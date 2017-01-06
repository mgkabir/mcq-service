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
	@Column(name="REASON")
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

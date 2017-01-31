package org.matrix.user.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {

	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

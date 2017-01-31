package org.matrix.user.service;

import org.matrix.user.model.User;

public interface UserService {

	public User getUser(String userName, String password);

}

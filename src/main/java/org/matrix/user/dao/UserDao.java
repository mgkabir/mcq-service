package org.matrix.user.dao;

import org.matrix.user.model.User;

public interface UserDao {
	
	public User getUser(String userName, String password);

}

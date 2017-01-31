package org.matrix.user.service;

import javax.transaction.Transactional;

import org.matrix.user.dao.UserDao;
import org.matrix.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String userName, String password) {
		return this.userDao.getUser(userName, password);
	}

}

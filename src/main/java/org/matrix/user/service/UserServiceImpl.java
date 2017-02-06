package org.matrix.user.service;

import javax.transaction.Transactional;

import org.matrix.user.dao.UserDao;
import org.matrix.user.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public AppUser getUser(String userName, String password) {
		return this.userDao.getUser(userName, password);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userDao.loadUserByUsername(username);
	}

}

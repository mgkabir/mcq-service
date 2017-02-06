package org.matrix.user.dao;

import org.matrix.user.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends UserDetailsService {
	
	public AppUser getUser(String userName, String password);

}

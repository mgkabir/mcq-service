package org.matrix.user.service;

import org.matrix.user.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

	public AppUser getUser(String userName, String password);

}

package org.matrix.user.dao;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.matrix.user.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public AppUser getUser(String userName, String password) {
		System.out.println("UserDaoImpl.getUser() : userName = " + userName + " password = " + password);

		AppUser retrivedUser = (AppUser) getSession()
				.createQuery("FROM AppUser WHERE login.userName = :userName AND login.password = :password")
				.setParameter("userName", userName).setParameter("password", password).uniqueResult();

		return retrivedUser;
	}

	private AppUser getUserByUsername(String userName) {
		System.out.println("UserDaoImpl.getUser() : userName = " + userName);

		AppUser retrivedUser = (AppUser) getSession().createQuery("FROM AppUser WHERE login.userName = :userName ")
				.setParameter("userName", userName).uniqueResult();

		return retrivedUser;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		AppUser appUser = this.getUserByUsername(userName);
		UserDetails userDetails = null;
		if (null != appUser) {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
			userDetails = new User(appUser.getLogin().getUserName(), appUser.getLogin().getPassword(),
					Arrays.asList(authority));

		} else {
			throw new UsernameNotFoundException(String.format("User %s Not Found", userName));
		}
		return userDetails;
	}

}

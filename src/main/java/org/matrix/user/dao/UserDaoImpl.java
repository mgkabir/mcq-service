package org.matrix.user.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.matrix.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public User getUser(String userName, String password) {
		System.out.println("UserDaoImpl.getUser() : userName = " + userName + " password = " + password);

		User retrivedUser = (User) getSession()
				.createQuery("FROM User WHERE login.userName = :userName AND login.password = :password")
				.setParameter("userName", userName).setParameter("password", password).uniqueResult();

		return retrivedUser;
	}
}

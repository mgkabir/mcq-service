package org.matrix.user.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.matrix.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDao {

	@Autowired
	private SessionFactory _sessionFactory;

	private Session getSession() {
		return _sessionFactory.getCurrentSession();
	}

	public void save(User user) {
		getSession().save(user);
		return;
	}

	public void delete(User user) {
		getSession().delete(user);
		return;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return getSession().createQuery("from User").list();
	}

	public User getByEmail(String email) {
		return (User) getSession().createQuery("from User where email = :email").setParameter("email", email)
				.uniqueResult();
	}

	public User getById(long id) {
		System.out.println("Id at DAo: " + id);
		return (User) getSession().get(User.class, id);

		/*
		 * return (User) getSession().createQuery( "from User where id = :id")
		 * .setParameter("id", id) .uniqueResult();
		 */
	}

	public void update(User user) {
		getSession().update(user);
		return;
	}

} // class UserDao

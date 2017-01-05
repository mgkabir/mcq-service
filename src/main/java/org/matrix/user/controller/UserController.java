package org.matrix.user.controller;

import java.util.Collection;

import org.matrix.user.dao.UserDao;
import org.matrix.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Collection<User> getAllUsers() {
		return this.userDao.getAll();
	}

	@RequestMapping(value="/{Id}", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getUserById(@PathVariable("Id") Long Id) {
		System.out.println("Id : "+Id);
		User aUser = userDao.getById(Id.longValue());
		System.out.println("User Email : "+aUser.getEmail());
		return aUser;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping(value = "/get-by-email")
	@ResponseBody
	public User getByEmail(String email) {
		User user = null;
		try {
			user = userDao.getByEmail(email);
			// userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return null;
		}
		return user;
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String create(String email, String name) {
		try {
			User user = new User(email, name);
			userDao.save(user);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "User succesfully saved!";
	}

} // class UserController

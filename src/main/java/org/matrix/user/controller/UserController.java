package org.matrix.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.matrix.user.model.Login;
import org.matrix.user.model.User;
import org.matrix.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Boolean> doLogin(@RequestBody Login login, HttpServletRequest request) {

		Boolean exists = false;
		User retrivedUSer = this.userService.getUser(login.getUserName(), login.getPassword());

		if (null != retrivedUSer) {
			exists = true;
			/* put this user into session for accessing later from session */
			request.getSession().setAttribute("loggedInUser", retrivedUSer);
		}

		System.out.println("UserController.doLogin() : UserExists ? " + exists);
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Boolean> doLogout(HttpServletRequest request) {
		
		request.getSession().removeAttribute("loggedInUser");
		System.out.println("UserController.doLogout() : called ");
		return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}
}

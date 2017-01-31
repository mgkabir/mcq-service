package org.matrix.user.controller;

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

	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public ResponseEntity<Boolean> checkLogin(@RequestBody Login login) {

		Boolean exists = false;
		User retrivedUSer = this.userService.getUser(login.getUserName(), login.getPassword());

		if (null != retrivedUSer)
			exists = true;
		/* If user exists put that into session */
		System.out.println("UserController.checkLogin() : UserExists ? " + exists);
		return new ResponseEntity<Boolean>(exists, HttpStatus.OK);
	}

}

package org.matrix.user.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void doLogin() {	
		/* */
	}

}
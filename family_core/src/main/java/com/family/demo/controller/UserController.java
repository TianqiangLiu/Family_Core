package com.family.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.family.demo.domain.User;
import com.family.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/api/login", method = RequestMethod.GET)
	public User userLogIn(@RequestParam(name = "username", required = true) String userName,
			@RequestParam(name = "password", required = true) String password) {
		User user = userService.findByUserName(userName);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}

	@RequestMapping(value = "/api/signup", method = RequestMethod.POST)
	public User userSignUp(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/api/profile", method = RequestMethod.GET)
	public User getUserProfile(@RequestParam(name = "accountId", required = true) String accountId) {
		if(accountId.isEmpty())
			return null;
		return userService.findById(Long.parseLong(accountId));
	}
	
	@RequestMapping(value = "/api/profile", method = RequestMethod.PATCH)
	public User changeUserProfile(@RequestBody User user) {
		return userService.changeUSer(user);
	}

}

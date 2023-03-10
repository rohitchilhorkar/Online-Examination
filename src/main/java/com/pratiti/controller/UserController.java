package com.pratiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.entity.User;
import com.pratiti.exception.UserServiceException;
import com.pratiti.model.LoginData;
import com.pratiti.model.LoginStatus;
import com.pratiti.model.RegistrationStatus;
import com.pratiti.service.UserService;


@RestController
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;

		@PostMapping("/register")
		public RegistrationStatus register(@RequestBody User user) {
			try {
				System.out.println(user.getPassword());
				int id = userService.register(user);
				RegistrationStatus registrationStatus = new RegistrationStatus();
				registrationStatus.setStatus(true);
				registrationStatus.setMessage("Customer register successfully");
				registrationStatus.setRegisteredCustomerId(id);
				return registrationStatus;
		
			} catch (UserServiceException e) {
				RegistrationStatus registrationStatus = new RegistrationStatus();
				registrationStatus.setStatus(false);
				registrationStatus.setMessage(e.getMessage());
				return registrationStatus;
			}
		}


		@PostMapping("/login")
		public LoginStatus login(@RequestBody LoginData loginData) {
			try {
				User user = userService.login(loginData.getEmail(), loginData.getPassword());
				LoginStatus loginStatus = new LoginStatus();
				loginStatus.setStatus(true);
				loginStatus.setId(user.getUserId());
				loginStatus.setName(user.getName());
				loginStatus.setMessage("Login successfully");
				return loginStatus;
			} catch (UserServiceException e) {
				LoginStatus loginStatus = new LoginStatus();
				loginStatus.setStatus(false);
				loginStatus.setMessage(e.getMessage());
				return loginStatus;
			}
		}
		
		@GetMapping("/view-details")
		public User viewDetails(@RequestParam("id") int id) {
			return userService.ViewDetails(id);
		}

}

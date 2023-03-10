package com.pratiti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.User;
import com.pratiti.exception.UserServiceException;
import com.pratiti.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	                                      
	public int register(User user) {
		if(userRepository.existsByEmail(user.getEmail()) == false) {
			userRepository.save(user);
			return user.getUserId();
		}
		else {
			throw new UserServiceException("Student with email " + user.getEmail() + " already exists.");
		}
	}
	
	
	public User login(String email , String password) {	
		Optional<User> c = userRepository.findByEmailAndPassword(email,password);
		if(c.isPresent()) {	 
			throw new UserServiceException("Accoumy logged in successfully!");
		}
		else 
		{
			throw new UserServiceException("Enter valid email address or password");
		}
	}
	
	
	public User ViewDetails(int id) {		
		return userRepository.findById(id).get();		
	}
	
	
}

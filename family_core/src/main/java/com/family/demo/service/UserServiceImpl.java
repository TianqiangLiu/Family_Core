package com.family.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.demo.domain.User;
import com.family.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Long id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User changeUSer(User user) {
		
		return userRepository.save(user);
	}
	

}

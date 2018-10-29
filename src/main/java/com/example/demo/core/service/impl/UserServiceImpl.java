package com.example.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.core.domain.User;
import com.example.demo.core.domain.dao.UserRepository;
import com.example.demo.core.service.UserService;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getByFacebookId(String id) {
		return userRepository.getByFacebookId(id);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}

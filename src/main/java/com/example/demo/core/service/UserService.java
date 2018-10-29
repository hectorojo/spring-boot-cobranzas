package com.example.demo.core.service;

import com.example.demo.core.domain.User;

public interface UserService {

	User getByFacebookId(String id);

	void saveUser(User user);

}

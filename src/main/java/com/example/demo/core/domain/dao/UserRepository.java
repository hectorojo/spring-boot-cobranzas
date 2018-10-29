package com.example.demo.core.domain.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.core.domain.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	User findByEmail(String email);
	
	User getByFacebookId(String id);

	

}

package com.example.demo.core.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APP_USER")
public class User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="FACEBOOK_ID", nullable=false)
	private String facebookId;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

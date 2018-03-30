package com.example.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "users")
public class UsersNew implements Serializable {
	
	private static final long serialVersionUID = 559306025307787242L;

	@Id
	@Column(name = "userName")
	private Long userName;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "emailId")
	private String emailId;
	
	@NotNull
	@Column(name = "createdOn")
	private String createdOn;
	
	@Column(name = "token")
	private int token;

	/**
	 * @return the userName
	 */
	public Long getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(Long userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the createdOn
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the token
	 */
	public int getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(int token) {
		this.token = token;
	}
	
	
}
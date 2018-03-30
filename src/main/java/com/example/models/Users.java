package com.example.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class Users implements Serializable {
    private static final long serialVersionUID = -7988799579036225139L;
    
    @Id
    @Column (name="userName")
    private String userName;
    
    @Column
    private String password;
    
    @Column
    private String emailId;
    
    @Column
    private String userType;
    
    @Column
    private Date createdOn;
    
    @Column
    private String token;
    
    public Users() {
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	@Override
    public String toString() {
        return "User {" +
                " userName="  + userName +
                ", password="  + password +
                ", emailId="   + emailId +
                ", userType="  + userType +
                ", createdOn=" + createdOn +
                ", token=" + token +
                "}";
    }
}

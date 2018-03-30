package com.example.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "login")
public class Login implements Serializable {
    private static final long serialVersionUID = -7988799579036225137L;
    
    @Id
    @Column (name="userName")
    private String userName;
    
    @Column
    private String password;
       
    public Login() {
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

	@Override
    public String toString() {
        return "Login{" +
                "userName=" + userName +
                ", password='" + password +'}';
    }
}

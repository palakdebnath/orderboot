package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.LoginDAO;
import com.example.models.Users;
import com.example.valueobjects.LoginRequest;
import com.example.valueobjects.LoginResponse;
import com.example.valueobjects.LogoutResponse;
import com.example.valueobjects.SigninRequest;
import com.example.valueobjects.SigninResponse;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public LoginResponse login(LoginRequest loginRequest) {
		return loginDAO.login(loginRequest);
	}
	
	@Override
	public LogoutResponse logout(String userName) {
		return loginDAO.logout(userName);
	}
	
	@Override
	public SigninResponse signIn(SigninRequest signinRequest) {
		Users user = new Users();
		
		user.setUserName(signinRequest.getUserName());
		user.setPassword(signinRequest.getPassword());
		user.setEmailId(signinRequest.getEmailId());
		user.setUserType(signinRequest.getUserType());
		user.setCreatedOn(new Date());
		return loginDAO.signIn(user);
	}
	
	@Override
	public boolean isUserNameAvailable(String userName) {
		return loginDAO.isUserNameAvailable(userName);
	}

}

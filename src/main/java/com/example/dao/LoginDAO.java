package com.example.dao;

import com.example.models.Users;
import com.example.valueobjects.LoginRequest;
import com.example.valueobjects.LoginResponse;
import com.example.valueobjects.LogoutResponse;
import com.example.valueobjects.SigninResponse;

public interface LoginDAO {
	public LoginResponse login(LoginRequest loginRequest);
	
	public LogoutResponse logout(String userName);
	
	public SigninResponse signIn(Users user);
	
	public boolean isUserNameAvailable(String userName);
}

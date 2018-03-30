package com.example.service;

import com.example.valueobjects.LoginRequest;
import com.example.valueobjects.LoginResponse;
import com.example.valueobjects.LogoutResponse;
import com.example.valueobjects.SigninRequest;
import com.example.valueobjects.SigninResponse;

public interface LoginService {
	
	public LoginResponse login(LoginRequest loginRequest);
	
	public LogoutResponse logout(String userName);
    
	public SigninResponse signIn(SigninRequest signinRequest);
	
	public boolean isUserNameAvailable(String userName);
}

package com.example.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.constants.CommonConstants;
import com.example.models.Users;
import com.example.repository.UsersRepository;
import com.example.util.CommonUtil;
import com.example.valueobjects.LoginRequest;
import com.example.valueobjects.LoginResponse;
import com.example.valueobjects.LogoutResponse;
import com.example.valueobjects.SigninResponse;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private UsersRepository usersRepository;

	public LoginDAOImpl() {
		System.out.println("LoginDAOImpl");
	}

	/*	@Override
	public boolean login(LoginRequest loginRequest){

		Login loginDetails = hibernateUtil.fetchByUserName(loginRequest.getUserName(), Login.class);
		if(loginDetails != null) {
			if(loginDetails.getPassword().equals(loginRequest.getPassword())) {
				return true;
			}
		}
		return false;
	}*/

	@Override
	public LoginResponse login(LoginRequest loginRequest){

		LoginResponse loginResponse = new LoginResponse();	
		String token = null;

		Users userDetails = usersRepository.findOne(loginRequest.getUserName());
				
		if(userDetails != null) {
			if(userDetails.getPassword().equals(loginRequest.getPassword())) {
				if(userDetails.getToken() != null && userDetails.getToken().length() > 0) {
					loginResponse.setReturnCode(CommonConstants.SUCCESS);
					loginResponse.setToken(userDetails.getToken());
					loginResponse.setReturnMessage(loginRequest.getUserName()  + " already logged-in!");

				} else {
					token = CommonUtil.randomString(loginRequest.getUserName());

					// Update Users table 
					userDetails.setToken(token);
					usersRepository.save(userDetails);

					loginResponse.setReturnCode(CommonConstants.SUCCESS);
					loginResponse.setToken(token);
					loginResponse.setReturnMessage(CommonConstants.LOGIN_SUCCESS_MSG);
				}
			} else {
				loginResponse.setReturnCode(CommonConstants.FAIL);
				loginResponse.setReturnMessage(CommonConstants.LOGIN_FAILURE_MSG);
			}		
		} else {
			loginResponse.setReturnCode(CommonConstants.FAIL);
			loginResponse.setReturnMessage(loginRequest.getUserName() + " - wrong userName. User not registered!");
		}
		
		return loginResponse;
	}

	
    @Override
    public LogoutResponse logout(String userName){
    	LogoutResponse logoutResponse = new LogoutResponse();	
    	Users userDetails = usersRepository.findOne(userName);
    			//hibernateUtil.fetchByUserName(userName, Users.class);

    	if(userDetails != null) {

    		if(userDetails.getToken() != null && userDetails.getToken().length() > 0) { 
    			//Set token to null and update Users table
    			userDetails.setToken(CommonConstants.EMPTY_STRING);
    			usersRepository.save(userDetails);
     			logoutResponse.setReturnCode(CommonConstants.SUCCESS);
    			logoutResponse.setReturnMessage(userName + " logged out successfully!");
    		} else {
    			logoutResponse.setReturnCode(CommonConstants.FAIL);
    			logoutResponse.setReturnMessage(userName + " already logged out!");
    		}
    	}
    	return logoutResponse;
    }

	 

	@Override
	public SigninResponse signIn(Users user) {
		Serializable resultUser;
		SigninResponse response = new SigninResponse();
		try {
			// If userName is available then only create new use, Otherwise do not create any user 
			if(isUserNameAvailable(user.getUserName())) {
				resultUser = usersRepository.save(user);
				response.setReturnMessage(resultUser + " successfully Signed-up!");
				response.setReturnCode(CommonConstants.SUCCESS);
			} else {
				response.setReturnMessage(user.getUserName() + " user already exists!");
				response.setReturnCode(CommonConstants.FAIL);
			}

		}
		catch(Exception ex) {
			response.setReturnMessage(user.getUserName() + " user creation error!" 
					+ " Exception : " + ex.getMessage());
			response.setReturnCode(CommonConstants.FAIL);
		}		
		return response;
	}

	@Override
	public boolean isUserNameAvailable(String userName) {
		Users foundUser = usersRepository.findOne(userName);

		if(foundUser != null && foundUser.getUserName() != null && foundUser.getUserName().equalsIgnoreCase(userName)) {
			return false;
		}
		return true;
	}
}

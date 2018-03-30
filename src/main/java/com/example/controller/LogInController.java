package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.LoginService;
import com.example.valueobjects.LoginRequest;
import com.example.valueobjects.LoginResponse;
import com.example.valueobjects.LogoutResponse;
import com.example.valueobjects.SigninRequest;
import com.example.valueobjects.SigninResponse;

@Controller
@RequestMapping("/user")
public class LogInController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login", method = RequestMethod.POST, headers = {"Content-Type=application/json"} )
	public @ResponseBody LoginResponse login(@RequestBody LoginRequest loginRequest) {
		return loginService.login(loginRequest);  
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/logout/{userName}")
	public @ResponseBody LogoutResponse logout(@PathVariable String userName) {
		return loginService.logout(userName);
	}
	
	@RequestMapping(value="/signin", method = RequestMethod.POST, headers = {"Content-Type=application/json"} )
	public @ResponseBody SigninResponse signIn(@RequestBody SigninRequest signinRequest) {
		return loginService.signIn(signinRequest);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/isUserNameAvaiable/{userName}")
	public @ResponseBody boolean isUserNameAvailable(@PathVariable("userName") String userName) {
		return loginService.isUserNameAvailable(userName);
	}
}

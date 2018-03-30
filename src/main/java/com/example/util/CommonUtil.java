package com.example.util;

import java.security.SecureRandom;

public class CommonUtil {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public static String randomString(String userName){
	   StringBuilder sb = new StringBuilder(userName.length() * 2);
	   int len = userName.length();
	   for( int i = 0; i < len; i++ ) 
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	   return sb.toString();
	}
}

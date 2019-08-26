package com.example.securudemo.security;

public class JwtProperties {

	
	//token için kullanılacak sabitler
	public static final String SECRET = "irsat";
	public static final int EXPIRATION_TIME = 864000000; //on gün
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

}

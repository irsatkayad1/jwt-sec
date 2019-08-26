package com.example.securudemo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.example.securudemo.model.LoginViewModel;

import com.fasterxml.jackson.databind.ObjectMapper;



import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authenticationManager;

	public JwtAuthFilter(AuthenticationManager authenticationManager) {
		
		this.authenticationManager = authenticationManager;
	}
	
	/*   /login sayfasına post yollandığında tetiklenir. 
	 *	veriler body kısmında {"username":"irsat", "password":"irsat123"} şeklinde yollanmalı		
	 * 
	 * */
	
	
	
	@Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        
        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // login tokeni
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());

        // kullanici authenticate oluyor
        Authentication auth = authenticationManager.authenticate(authenticationToken);

        return auth;
    }
	
	@Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        
        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        // jwt tokeni
        String token = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        //token responsa ekleniyor
        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX +  token);
    }

	
	

}

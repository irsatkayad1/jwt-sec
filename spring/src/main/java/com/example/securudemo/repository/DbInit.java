package com.example.securudemo.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.securudemo.model.User;

@Service
public class DbInit implements CommandLineRunner{

	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;
	
	public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void run(String... args) {
		userRepository.deleteAll();
		//create ma users babe
		User irsat = new User("irsat", passwordEncoder.encode("irsat"),"USER","");
		User admin = new User("admin", passwordEncoder.encode("admin"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
		User manager = new User("manager", passwordEncoder.encode("manager"),"MANAGER","ACCESS_TEST1");
		
		List<User> users =Arrays.asList(irsat,admin,manager);
		
		//saving to DB reis
		this.userRepository.saveAll(users);
	}
}

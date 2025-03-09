package com.security.learn;

import com.security.learn.entites.User;
import com.security.learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@SpringBootApplication
public class SecurityProjectApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		String userName = "amit";
		User user = userRepository.findByUserName(userName).orElse(null);

		if(user== null){
			user = new User();
			user.setUserId(UUID.randomUUID().toString());
			user.setUserName(userName);
			user.setPassword(passwordEncoder.encode("patel"));
			user.setRole("USER");
			userRepository.save(user);
			System.out.println("User is created!!");
		}
		System.out.println("User created with user id : "+user.getUserId());
	}
}

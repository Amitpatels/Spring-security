package com.security.learn;

import com.security.learn.entites.Role;
import com.security.learn.entites.User;
import com.security.learn.repository.RoleRepository;
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
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		createRoles("ROLE_ADMIN");
		createRoles("ROLE_GUEST");

		String userName = "amit";
		User user = userRepository.findByUserName(userName).orElse(null);

		if(user== null){
			user = new User();
			user.setUserId(UUID.randomUUID().toString());
			user.setUserName(userName);
			user.setPassword(passwordEncoder.encode("patel"));
			//user.setRole("USER");
			userRepository.save(user);
			System.out.println("User is created!!");
		}
		System.out.println("User created with user id : "+user.getUserId());
	}


	public void createRoles(String role){
		Role roleExist = roleRepository.findByName(role).orElse(null);
		if(roleExist==null){
			Role role2 = new Role();
			role2.setId(UUID.randomUUID().toString());
			role2.setName(role);
			Role createdRole = roleRepository.save(role2);
			System.out.println("Role created successfully : "+createdRole);
		}
	}

}

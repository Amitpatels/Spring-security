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

import java.util.ArrayList;
import java.util.List;
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

		String role1 = "ROLE_ADMIN";
		String role2 = "ROLE_GUEST";
		Role roleExist1 = createRoles(role1);
		Role roleExist2 = createRoles(role2);

		String userName = "amit";
		createUser(userName,roleExist1,roleExist2);
		String userName2 = "ravi";
		createUser(userName2,null,roleExist2);
	}

	public void createUser(String userName, Role role1, Role role2){

		List<Role> roles = new ArrayList<>();
		if(role1 != null){
			roles.add(role1);
		}
		if(role2 != null){
			roles.add(role2);
		}


		User user = userRepository.findByUserName(userName).orElse(null);
		if(user== null){
			user = new User();
			user.setUserId(UUID.randomUUID().toString());
			user.setUserName(userName);
			user.setPassword(passwordEncoder.encode("patel"));
			user.setRoles(roles);
			userRepository.save(user);
			System.out.println("User is created!!");
		}
	}

	public Role createRoles(String role){
		Role roleExist = roleRepository.findByName(role).orElse(null);
		if(roleExist==null){
			Role role2 = new Role();
			role2.setId(UUID.randomUUID().toString());
			role2.setName(role);
			Role createdRole = roleRepository.save(role2);
			System.out.println("Role created successfully : "+createdRole);
		}
		return roleExist;
	}

}

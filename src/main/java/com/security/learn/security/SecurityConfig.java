package com.security.learn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity(debug = true)
@Configuration
public class SecurityConfig {

   /* @Bean
    public UserDetailsService userDetailsService(){
        //using without database
       UserDetails userDetails1 = User.withDefaultPasswordEncoder()
                .username("amit")
                .password("amit")
                .roles("ADMIN","GUEST")
                .build();

        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("nikki")
                .password("nikki")
                .roles("ADMIN")
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(userDetails1,userDetails2);

        return inMemoryUserDetailsManager;
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}

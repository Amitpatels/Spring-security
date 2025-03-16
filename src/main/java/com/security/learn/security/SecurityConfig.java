package com.security.learn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
       /* httpSecurity.authorizeHttpRequests(
            request -> {
                //api/route2 -> public
                request.requestMatchers("/api/route2","/register").permitAll();
                request.requestMatchers("/users/**").permitAll();
                request.requestMatchers(HttpMethod.POST,"/products");
                //baki ko authenticated
                request.anyRequest().authenticated();
            }
        );*/

       /* httpSecurity.authorizeHttpRequests(
                request -> {
                    //api/route2 -> public
                    request.requestMatchers("/api/route2").permitAll()
                    .requestMatchers("/users/**").permitAll()
                    .requestMatchers(HttpMethod.POST,"/products").authenticated()
                    //baki ko authenticated
                    .anyRequest().authenticated();
                }
        );*/

       //httpSecurity.authorizeHttpRequests(request -> request.anyRequest().permitAll());
        httpSecurity.authorizeHttpRequests(
            request -> request
                    .requestMatchers("/api/route1","/api/route2").hasRole("ADMIN")
                    .requestMatchers("/api/route3","/api/route4").hasRole("GUEST")
                    .anyRequest().permitAll()
        );


        //form based login
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
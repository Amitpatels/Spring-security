package com.security.learn.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "spring_security_users")
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    String role = "USER";
}
package com.security.learn.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "spring_security_users")
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();
}
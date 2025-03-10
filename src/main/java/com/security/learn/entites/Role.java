package com.security.learn.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Role {

    @Id
    String id;
    String name;

    //ROLE_ADMIN
    //ROLE_GUEST

    @ManyToMany( mappedBy = "roles",fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

}

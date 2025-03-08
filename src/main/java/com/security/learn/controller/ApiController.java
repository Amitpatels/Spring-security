package com.security.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/route1")
    public String route1(){
        return "This is protected route1";
    }

    @GetMapping("/route2")
    public String route3(){
        return "This is protected route2";
    }
}

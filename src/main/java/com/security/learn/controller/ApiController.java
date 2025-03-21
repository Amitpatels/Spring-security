package com.security.learn.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/route1")
    public String route1(){
        return "( The menu changed ):This is protected route1";
    }

    @GetMapping("/route2")
    public String route2(){
        return "( Change price of menu ):This is protected route2";
    }

    @GetMapping("/route3")
    public String route3(){
        return "( Order food ):This is protected route3";
    }

    @GetMapping("/route4")
    public String route4(){
        return "( Pay Bill ):This is protected route2";
    }

    @GetMapping("/route5")
    @PreAuthorize("hasRole('ADMIN')")
    public String route5(){
        return "( Drink water ):This is protected route2";
    }
}

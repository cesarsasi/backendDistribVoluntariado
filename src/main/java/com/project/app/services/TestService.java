package com.project.app.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Bienvenido al back de td";
    }
    @GetMapping("/")
    public String Home(){
        return "Home";
    }
}
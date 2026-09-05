package com.teluskoLearning.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teluskoLearning.demo.model.User;
import com.teluskoLearning.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserService service;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return "Success";
        }
        else{
            return "Login Failed";
        }
    }
}

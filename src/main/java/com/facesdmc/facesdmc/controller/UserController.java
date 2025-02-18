package com.facesdmc.facesdmc.controller;

import com.facesdmc.facesdmc.model.AppUser;
import com.facesdmc.facesdmc.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public AppUser createUser(@RequestBody AppUser appUser) {
        return userRepository.save(appUser);
    }
}


package com.example.twu.controller;

import com.example.twu.entities.User;
import com.example.twu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity loginUser(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        if(userRepository.loginUser(name, password)){
            return new ResponseEntity<>("login success", HttpStatus.OK);
        }
        return new ResponseEntity<>("login fail", HttpStatus.UNAUTHORIZED);
    }
}

package com.example.twu.controller;

import com.example.twu.entities.User;
import com.example.twu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class LoggedUserController {
    @Autowired
    private UserRepository userRepository;

    ResponseEntity getUserInfo() {
        User loggedUser = userRepository.getLoggedUser();
        if(loggedUser == null) {
            return new ResponseEntity<>("please login first", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(loggedUser, HttpStatus.OK);
    }
}

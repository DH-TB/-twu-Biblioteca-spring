package com.example.twu.demo.controller;

import com.example.twu.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/menus")
    public ResponseEntity getMenus() {
        return new ResponseEntity<>(menuRepository.getMenus(), HttpStatus.OK);
    }

}

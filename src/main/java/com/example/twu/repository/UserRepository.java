package com.example.twu.repository;

import com.example.twu.entities.User;

public interface UserRepository {
    User addUser(User user);

    boolean loginUser(String name, String password);

}

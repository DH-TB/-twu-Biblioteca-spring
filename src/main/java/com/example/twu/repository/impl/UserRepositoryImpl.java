package com.example.twu.repository.impl;

import com.example.twu.entities.User;
import com.example.twu.repository.UserRepository;
import com.example.twu.repository.storage.UserStorage;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Override
    public User addUser(User user) {
        return UserStorage.addUser(user);
    }

    @Override
    public boolean loginUser(String name, String password) {
        return UserStorage.loginUser(name, password);
    }

    @Override
    public User getLoggedUser() {
        return UserStorage.getLoggedUser();
    }
}

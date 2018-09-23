package com.example.twu.repository.impl;

import com.example.twu.entities.User;
import com.example.twu.repository.UserRepository;
import com.example.twu.repository.storage.UserStorage;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Override
    public User createUser(User user) {
        return UserStorage.createUser(user);
    }
}

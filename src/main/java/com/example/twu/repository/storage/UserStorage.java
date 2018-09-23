package com.example.twu.repository.storage;

import com.example.twu.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static final List<User> USERS = new ArrayList<>();

    public static void clear() {
        USERS.clear();
    }

    public static int getSize() {
        return USERS.size();
    }

    public static User createUser(User user) {
        USERS.add(user);
        return user;
    }
}

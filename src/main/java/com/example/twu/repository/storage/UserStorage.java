package com.example.twu.repository.storage;

import com.example.twu.entities.User;

import java.util.HashMap;

public class UserStorage {
    private static final HashMap<String, User> USERS = new HashMap<>();

    public static void clear() {
        USERS.clear();
    }

    public static int getSize() {
        return USERS.size();
    }

    public static User addUser(User user) {
        USERS.put(user.getName(), user);
        return user;
    }

    public static boolean loginUser(String name, String password) {
        User user = USERS.get(name);
        return user.getPassword().equals(password);
    }
}

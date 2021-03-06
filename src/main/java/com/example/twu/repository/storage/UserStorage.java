package com.example.twu.repository.storage;

import com.example.twu.entities.User;

import java.util.HashMap;

public class UserStorage {
    private static final HashMap<String, User> USERS = new HashMap<>();
    private static User LOGGED_USER = null;

    public static void clear() {
        USERS.clear();
        LOGGED_USER = null;
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
        if (user != null) {
            LOGGED_USER = user;
            return user.getPassword().equals(password);
        }
        return false;
    }

    public static User getLoggedUser() {
        return LOGGED_USER;
    }

    public static void setLoggedUser(User user) {
        LOGGED_USER = user;
    }
}

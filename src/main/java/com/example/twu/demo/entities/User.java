package com.example.twu.demo.entities;

public class User {
    private String id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;

    public User(String id, String name, String password, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

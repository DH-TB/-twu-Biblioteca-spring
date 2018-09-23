package com.example.twu.entities;

public enum Option {
    LOGIN(1),
    SHOW_ALL_BOOK(2),
    SHOW_ALL_MOVIE(3),
    CHECKOUT_BOOK(4),
    CHECKOUT_MOVIE(5),
    RETURN_BOOK(6),
    MY_USER_INFO(7),
    EXIT(8);

    private int value;

    Option(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

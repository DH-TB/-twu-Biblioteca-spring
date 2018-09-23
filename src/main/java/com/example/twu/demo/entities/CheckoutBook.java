package com.example.twu.demo.entities;

public class CheckoutBook {
    private String userId;
    private int bookId;


    public CheckoutBook(String userId, int bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public int getBookId() {
        return bookId;
    }
}

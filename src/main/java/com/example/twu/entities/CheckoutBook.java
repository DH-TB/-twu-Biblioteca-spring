package com.example.twu.entities;

public class CheckoutBook {
    private String userId;
    private Integer bookId;


    public CheckoutBook(String userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getBookId() {
        return bookId;
    }
}

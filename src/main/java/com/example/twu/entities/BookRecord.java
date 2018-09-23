package com.example.twu.entities;

public class BookRecord {
    private Integer id;
    private String userId;
    private Integer bookId;
    private boolean isReturned;

    public BookRecord() {
    }

    public BookRecord(Integer id, String userId, Integer bookId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public Integer getBookId() {
        return bookId;
    }
}

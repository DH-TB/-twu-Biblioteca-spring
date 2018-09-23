package com.example.twu.entities;

public class MovieRecord {
    private Integer id;
    private String userId;
    private Integer movieId;
    private boolean isReturned;

    public MovieRecord() {
    }

    public MovieRecord(Integer id, String userId, Integer movieId) {
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public String getUserId() {
        return userId;
    }

    public int getMovieId() {
        return movieId;
    }
}

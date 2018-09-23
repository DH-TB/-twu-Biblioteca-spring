package com.example.twu.entities;

public class Movie {
    private int id;
    private String name;
    private String year;
    private String director;
    private int rate;

    public Movie() {
    }

    public Movie(int id, String name, String year, String director, int rate) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRate() {
        return rate;
    }
}

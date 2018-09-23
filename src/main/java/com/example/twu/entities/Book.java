package com.example.twu.entities;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private String year;
    private String publication;

    public Book() {
    }

    public Book(Integer id, String name, String author, String year, String publication) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.publication = publication;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getPublication() {
        return publication;
    }
}

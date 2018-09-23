package com.example.twu.repository;

import com.example.twu.entities.Book;

import java.util.Collection;

public interface BookRepository {
    Collection<Book> getBooks();

    Book addBook(Book book);

    Book findBook(Integer bookId);

}

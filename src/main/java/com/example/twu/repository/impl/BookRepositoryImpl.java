package com.example.twu.repository.impl;

import com.example.twu.entities.Book;
import com.example.twu.repository.BookRepository;
import com.example.twu.repository.storage.BookStorage;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Override
    public Collection<Book> getBooks() {
        return BookStorage.getBooks();
    }

    @Override
    public Book addBook(Book book) {
        return BookStorage.addBook(book);
    }

    @Override
    public Book findBook(Integer bookId) {
        return BookStorage.findBook(bookId);
    }
}

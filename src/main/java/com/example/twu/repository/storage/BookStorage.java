package com.example.twu.repository.storage;

import com.example.twu.entities.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BookStorage {
    private static final Map<Integer, Book> BOOKS = new HashMap<>();

    public static void clear() {
        BOOKS.clear();
    }

    public static Collection<Book> getBooks() {
        return BOOKS.values();
    }

    public static int getSize() {
        return BOOKS.size();
    }

    public static Book addBook(Book book) {
        BOOKS.put(book.getId(), book);
        return book;
    }
}

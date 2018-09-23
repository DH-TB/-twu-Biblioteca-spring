package com.example.twu.controller;

import com.example.twu.entities.Book;
import com.example.twu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public ResponseEntity addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookRepository.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity getBooks() {
        return new ResponseEntity<>(bookRepository.getBooks(), HttpStatus.OK);
    }
}

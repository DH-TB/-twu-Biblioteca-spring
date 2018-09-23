package com.example.twu.controller;

import com.example.twu.repository.BookRepository;
import com.example.twu.repository.CheckoutBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CheckoutBookController {

    @Autowired
    private CheckoutBookRepository checkoutBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/checkout_books/{bookId}")
    public ResponseEntity checkoutBook(@PathVariable Integer bookId, @RequestHeader(value = "userId") String userId) {
        if (bookRepository.findBook(bookId) != null) {
            checkoutBookRepository.checkoutBook(bookId, userId);
            return new ResponseEntity<>("Thank you! Enjoy the book.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That book is not available.", HttpStatus.BAD_REQUEST);
    }
}

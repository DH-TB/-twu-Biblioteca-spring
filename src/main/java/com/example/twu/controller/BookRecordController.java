package com.example.twu.controller;

import com.example.twu.entities.BookRecord;
import com.example.twu.entities.User;
import com.example.twu.repository.BookRepository;
import com.example.twu.repository.BookRecordRepository;
import com.example.twu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookRecordController {

    @Autowired
    private BookRecordRepository bookRecordRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/book-records")
    public ResponseEntity checkoutBook(@RequestBody BookRecord bookRecord) {
        if(userNotLogin()) {
            return new ResponseEntity<>("please login first", HttpStatus.BAD_REQUEST);
        }
        if (bookRepository.findBook(bookRecord.getBookId()) != null) {
            bookRecordRepository.addRecord(bookRecord);
            return new ResponseEntity<>("Thank you! Enjoy the book.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That book is not available.", HttpStatus.BAD_REQUEST);
    }

    private boolean userNotLogin() {
        return userRepository.getLoggedUser() == null;
    }

    @PutMapping("/book-records/{bookRecordId}")
    public ResponseEntity returnBook(@PathVariable Integer bookRecordId) {
        if(userNotLogin()) {
            return new ResponseEntity<>("please login first", HttpStatus.BAD_REQUEST);
        }

        if(bookRecordRepository.containsRecord(bookRecordId)){
            bookRecordRepository.updateRecord(bookRecordId);
            return new ResponseEntity<>("Thank you for returning the book.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That is not a valid book to return.", HttpStatus.BAD_REQUEST);
    }


}

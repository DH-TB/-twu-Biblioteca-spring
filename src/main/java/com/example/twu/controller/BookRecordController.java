package com.example.twu.controller;

import com.example.twu.entities.BookRecord;
import com.example.twu.repository.BookRepository;
import com.example.twu.repository.BookRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookRecordController {

    @Autowired
    private BookRecordRepository checkoutBookRepository;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/book_records")
    public ResponseEntity checkoutBook(@RequestBody BookRecord bookRecord) {
        if (bookRepository.findBook(bookRecord.getBookId()) != null) {
            checkoutBookRepository.addRecord(bookRecord);
            return new ResponseEntity<>("Thank you! Enjoy the book.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That book is not available.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/book_records/{bookRecordId}")
    public ResponseEntity returnBook(@PathVariable Integer bookRecordId) {
        if(checkoutBookRepository.containsRecord(bookRecordId)){
            checkoutBookRepository.updateRecord(bookRecordId);
            return new ResponseEntity<>("Thank you for returning the book.", HttpStatus.OK);
        }
        return new ResponseEntity<>("That is not a valid book to return.", HttpStatus.BAD_REQUEST);
    }
}

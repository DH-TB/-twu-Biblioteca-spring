package com.example.twu.repository.impl;

import com.example.twu.entities.BookRecord;
import com.example.twu.repository.BookRecordRepository;
import com.example.twu.repository.storage.BookRecordStorage;
import org.springframework.stereotype.Repository;

@Repository
public class BookRecordRepositoryImpl implements BookRecordRepository {

    @Override
    public BookRecord addRecord(BookRecord bookRecord) {
        return BookRecordStorage.addRecord(bookRecord);
    }

    @Override
    public boolean updateRecord(Integer id) {
        return BookRecordStorage.updateRecord(id);
    }

    @Override
    public boolean containsRecord(Integer id) {
        return BookRecordStorage.containsRecord(id);
    }
}

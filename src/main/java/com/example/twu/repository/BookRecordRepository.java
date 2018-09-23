package com.example.twu.repository;

import com.example.twu.entities.BookRecord;

public interface BookRecordRepository {

    BookRecord addRecord(BookRecord bookRecord);

    boolean updateRecord(Integer id);

    boolean containsRecord(Integer id);
}

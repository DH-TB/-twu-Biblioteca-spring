package com.example.twu.repository.storage;

import com.example.twu.entities.BookRecord;

import java.util.HashMap;
import java.util.Map;

public class BookRecordStorage {
    private static final Map<Integer, BookRecord> BOOK_RECORD = new HashMap<>();

    public static void clear() {
    }

    public static BookRecord addRecord(BookRecord bookRecord) {
        BOOK_RECORD.put(bookRecord.getId(), bookRecord);
        return bookRecord;
    }

    public static boolean updateRecord(Integer id) {
        BookRecord bookRecord = BOOK_RECORD.get(id);
        bookRecord.setReturned(true);

        return bookRecord.isReturned();
    }

    public static boolean containsRecord(Integer id) {
        return BOOK_RECORD.containsKey(id);
    }
}

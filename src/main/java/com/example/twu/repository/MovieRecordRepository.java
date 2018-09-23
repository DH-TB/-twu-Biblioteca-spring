package com.example.twu.repository;

import com.example.twu.entities.MovieRecord;

public interface MovieRecordRepository {

    MovieRecord addRecord(MovieRecord movieRecord);

    boolean updateRecord(Integer id);

    boolean containsRecord(Integer id);
}

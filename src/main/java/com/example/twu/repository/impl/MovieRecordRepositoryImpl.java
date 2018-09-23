package com.example.twu.repository.impl;

import com.example.twu.entities.MovieRecord;
import com.example.twu.repository.MovieRecordRepository;
import com.example.twu.repository.storage.MovieRecordStorage;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRecordRepositoryImpl implements MovieRecordRepository {

    @Override
    public MovieRecord addRecord(MovieRecord movieRecord) {
        return MovieRecordStorage.addRecord(movieRecord);
    }

    @Override
    public boolean updateRecord(Integer id) {
        return MovieRecordStorage.updateRecord(id);
    }

    @Override
    public boolean containsRecord(Integer id) {
        return MovieRecordStorage.containsRecord(id);
    }
}

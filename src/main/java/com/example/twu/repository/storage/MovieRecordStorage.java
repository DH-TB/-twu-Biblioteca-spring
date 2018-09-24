package com.example.twu.repository.storage;

import com.example.twu.entities.MovieRecord;

import java.util.HashMap;
import java.util.Map;

public class MovieRecordStorage {
    private static final Map<Integer, MovieRecord> MOVIE_RECORD = new HashMap<>();

    public static void clear() {
        MOVIE_RECORD.clear();
    }

    public static boolean updateRecord(Integer id) {
        MovieRecord movieRecord = MOVIE_RECORD.get(id);
        movieRecord.setReturned(true);
        return movieRecord.isReturned();
    }

    public static boolean containsRecord(Integer id) {
        return MOVIE_RECORD.containsKey(id);
    }

    public static MovieRecord addRecord(MovieRecord movieRecord) {
        MOVIE_RECORD.put(movieRecord.getId(), movieRecord);
        return movieRecord;
    }
}

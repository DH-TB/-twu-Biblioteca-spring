package com.example.twu;

import com.example.twu.entities.*;
import com.example.twu.repository.storage.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovieRecordControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        MovieRecordStorage.clear();
    }

    @Test
    void should_checkout_movie_success_when_input_right_movie_id() throws Exception {
        Movie movie = new Movie(1, "movie", "2018/3/16", "huanglizhen", 10);
        MovieStorage.addMovie(movie);

        MovieRecord movieRecord = new MovieRecord(1, "111-1111", 1);

        mockMvc.perform(post("/api/movie-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movieRecord)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Thank you! Enjoy the movie."));
    }

    @Test
    void should_checkout_movie_fail_when_input_error_movie_id() throws Exception {
        MovieRecord movieRecord = new MovieRecord(1, "111-1111", 1);

        mockMvc.perform(post("/api/movie-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(movieRecord)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("That movie is not available."));
    }

    @Test
    void should_return_movie_success_when_input_correct_checkout_movieId() throws Exception {
        MovieRecord movieRecord = new MovieRecord(1, "111-1111", 1);
        MovieRecordStorage.addRecord(movieRecord);

        mockMvc.perform(put("/api/movie-records/{movieRecordId}", movieRecord.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Thank you for returning the movie."));
    }

    @Test
    void should_return_movie_fail_when_input_error_checkout_movieId() throws Exception {
        mockMvc.perform(put("/api/movie-records/{movieRecordId}", 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("That is not a valid movie to return."));
    }

}
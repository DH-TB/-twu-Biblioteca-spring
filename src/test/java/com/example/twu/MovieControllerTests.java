package com.example.twu;

import com.example.twu.entities.Book;
import com.example.twu.entities.Movie;
import com.example.twu.repository.storage.BookStorage;
import com.example.twu.repository.storage.MovieStorage;
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MovieControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        MovieStorage.clear();
    }

    @Test
    void should_add_movie() throws Exception {
        Movie movie = new Movie(1, "movie", "2018/3/16", "huanglizhen", 10);

        int originSize = MovieStorage.getSize();

        mockMvc.perform(post("/api/movies")
                .content(new ObjectMapper().writeValueAsString(movie))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("movie"));
        int currentSize = MovieStorage.getSize();

        assertEquals(originSize + 1, currentSize);
    }

    @Test
    void should_get_movies() throws Exception {
        Movie movie = new Movie(1, "movie", "2018/3/16", "huanglizhen", 10);
        Movie movie1 = new Movie(2, "movie1", "2018/3/16", "huanglizhen", 10);
        MovieStorage.addMovie(movie);
        MovieStorage.addMovie(movie1);

        mockMvc.perform(get("/api/movies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("movie"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("movie1"));
    }
}

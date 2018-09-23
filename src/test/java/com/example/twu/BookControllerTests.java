package com.example.twu;

import com.example.twu.entities.Book;
import com.example.twu.repository.storage.BookStorage;
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
class BookControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        BookStorage.clear();
    }

    @Test
    void should_add_book() throws Exception {
        Book book = new Book(1, "Java", "TWU", "2018/3/16", "人民邮电出版社");
        int originSize = BookStorage.getSize();

        mockMvc.perform(post("/api/books")
                .content(new ObjectMapper().writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Java"));
        int currentSize = BookStorage.getSize();

        assertEquals(originSize + 1, currentSize);
    }

    @Test
    void should_get_books() throws Exception {
        Book book = new Book(1, "Java", "TWU", "2018/3/16", "人民邮电出版社");
        Book book1 = new Book(2, "TDD", "TWU", "2018/3/16", "人民邮电出版社");
        BookStorage.addBook(book);
        BookStorage.addBook(book1);
        
        mockMvc.perform(get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Java"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("TDD"));

    }
}

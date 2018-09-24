package com.example.twu;

import com.example.twu.entities.Book;
import com.example.twu.entities.BookRecord;
import com.example.twu.entities.User;
import com.example.twu.repository.storage.BookStorage;
import com.example.twu.repository.storage.BookRecordStorage;
import com.example.twu.repository.storage.UserStorage;
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
class BookRecordControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        BookRecordStorage.clear();
        UserStorage.clear();
    }

    @Test
    void should_checkout_book_success_when_input_right_book_id() throws Exception {
        Book book = new Book(1, "Java", "TWU", "2018/3/16", "人民邮电出版社");
        BookStorage.addBook(book);

        User user = AddUserAndLogin();

        BookRecord bookRecord = new BookRecord(1, user.getId(), book.getId());

        mockMvc.perform(post("/api/book-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bookRecord)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Thank you! Enjoy the book."));
    }

    @Test
    void should_checkout_book_fail_when_input_error_book_id() throws Exception {
        User user = AddUserAndLogin();

        BookRecord bookRecord = new BookRecord(1, user.getId(), 1);

        mockMvc.perform(post("/api/book-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bookRecord)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("That book is not available."));
    }

    @Test
    void should_checkout_book_fail_when_user_not_login() throws Exception {
        BookRecord bookRecord = new BookRecord(1, "111-1111", 1);

        mockMvc.perform(post("/api/book-records")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(bookRecord)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("please login first"));
    }

    @Test
    void should_return_book_success_when_input_correct_checkout_bookId() throws Exception {
        AddUserAndLogin();

        BookRecord bookRecord = new BookRecord(1, "111-1111", 1);
        BookRecordStorage.addRecord(bookRecord);

        mockMvc.perform(put("/api/book-records/{bookRecordId}", bookRecord.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Thank you for returning the book."));
    }

    @Test
    void should_return_book_fail_when_input_error_checkout_bookId() throws Exception {
        AddUserAndLogin();

        mockMvc.perform(put("/api/book-records/{bookRecordId}", 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("That is not a valid book to return."));
    }

    @Test
    void should_return_book_fail_when_user_not_login() throws Exception {
        BookRecord bookRecord = new BookRecord(1, "111-1111", 1);
        BookRecordStorage.addRecord(bookRecord);

        mockMvc.perform(put("/api/book-records/{bookRecordId}", bookRecord.getId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("please login first"));
    }

    private User AddUserAndLogin() {
        User user = new User("111-1111", "user", "pass", "929659475@qq.com", "15091671302", "xi'an");
        UserStorage.addUser(user);
        UserStorage.setLoggedUser(user);

        return user;
    }
}
package com.example.twu;

import com.example.twu.entities.Book;
import com.example.twu.entities.User;
import com.example.twu.repository.storage.BookStorage;
import com.example.twu.repository.storage.CheckoutBookStorage;
import com.example.twu.repository.storage.UserStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CheckoutBookControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        CheckoutBookStorage.clear();
    }

    @Test
    void should_checkout_book_success_when_input_right_book_id() throws Exception {
        Book book = new Book(1, "Java", "TWU", "2018/3/16", "人民邮电出版社");
        BookStorage.addBook(book);

        User user = new User("111-1111", "user", "pass", "929659475@qq.com", "15091671302", "xi'an");
        UserStorage.addUser(user);

        mockMvc.perform(get("/api/checkout_books/{bookId}", 1)
                .header("userId", "111-1111"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Thank you! Enjoy the book."));
    }

    @Test
    void should_checkout_book_fail_when_input_error_book_id() throws Exception {
        User user = new User("111-1111", "user", "pass", "929659475@qq.com", "15091671302", "xi'an");
        UserStorage.addUser(user);

        mockMvc.perform(get("/api/checkout_books/{bookId}", 1)
                .header("userId", "111-1111"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("That book is not available."));
    }
}
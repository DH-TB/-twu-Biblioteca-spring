package com.example.twu;


import com.example.twu.entities.User;
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

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserControllerTests {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
        UserStorage.clear();
    }

    @Test
    void should_create_user() throws Exception {
        User user = new User("111-1111", "user", "pass", "929659475@qq.com", "15091671302", "xi'an");
        int originSize = UserStorage.getSize();

        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("111-1111"));

        int currentSize = UserStorage.getSize();
        assertEquals(originSize + 1, currentSize);
    }

    @Test
    void should_get_user_info() throws Exception {
        addUser();

        mockMvc.perform(get("/api/user-info"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("111-1111"))
                .andExpect(jsonPath("$.name").value("user"))
                .andExpect(jsonPath("$.address").value("xi'an"));
    }

    @Test
    void should_fail_get_user_info_when_not_login() throws Exception {
        mockMvc.perform(get("/api/user-info"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("please login first"));
    }

    @Test
    void should_login_success() throws Exception {
        addUser();

        mockMvc.perform(get("/api/users")
                .param("name", "user")
                .param("password", "pass"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("login success"));
    }

    @Test
    void should_login_fail_when_password_error() throws Exception {
        addUser();

        mockMvc.perform(get("/api/users")
                .param("name", "user")
                .param("password", "pass_error"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void should_login_fail_when_username_error() throws Exception {
        addUser();

        mockMvc.perform(get("/api/users")
                .param("name", "user_error")
                .param("password", "pass"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    void should_login_fail_when_user_not_exist() throws Exception {
        mockMvc.perform(get("/api/users")
                .param("name", "user")
                .param("password", "pass_error"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    private void addUser() {
        User user = new User("111-1111", "user", "pass", "929659475@qq.com", "15091671302", "xi'an");
        UserStorage.addUser(user);
        UserStorage.setLoggedUser(user);
    }
}

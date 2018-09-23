package com.example.twu.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DemoApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void should_get_menus() throws Exception {
        ResultActions perform = mockMvc.perform(get("/api/menus"));
        perform.andDo(print()).andExpect(status().isOk());

        String responseContent = perform.andReturn().getResponse().getContentAsString();
        String expectedContent = "\n***********\n" +
                "1 login\n" +
                "2 show all book\n" +
                "3 show all movie\n" +
                "4 checkout book\n" +
                "5 checkout movie\n" +
                "6 return book\n" +
                "7 my user info\n" +
                "8 exit\n" +
                "***********\n" +
                "please choose number you want：\n";

        assertEquals(responseContent, expectedContent);

    }

}
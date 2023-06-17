package com.example.demoweb;


import com.example.demoweb.controllers.PostsViewController;
import com.example.demoweb.models.Post;
import com.example.demoweb.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class MainTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostsViewController controller;

    // Integrations tests
    @Test
    public void shouldReturnDefaultMessage() throws Exception{
        this.mockMvc.perform(get("/post")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("HELLO APP")))
                .andExpect(content().string(containsString("Создать новый пост")));
    }

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}

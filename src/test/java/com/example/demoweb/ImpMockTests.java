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

import java.util.ArrayList;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(PostsViewController.class)
public class ImpMockTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    // Integrations tests
    @Test
    public void shouldReturnPost() throws Exception{
        Post post;
        when(postService.listAllPosts()).thenReturn(new ArrayList<Post>());
        this.mockMvc.perform(get("/post")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(contains(new ArrayList<Post>()).toString()));
    }

    @Test
    public void shouldRedirectToOtherPath() throws Exception{
        this.mockMvc.perform(get("/post")).andDo(print())
                .andExpect(status().isOk()).andExpect(content().string(containsString("HELLO APP")));
    }
}

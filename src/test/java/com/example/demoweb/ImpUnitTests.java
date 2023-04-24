package com.example.demoweb;

import com.example.demoweb.controllers.PostsViewController;
import com.example.demoweb.main.Main;
import com.example.demoweb.models.Post;
import com.example.demoweb.services.LikesService;
import com.example.demoweb.services.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

//@WebMvcTest

@WebMvcTest
@ContextConfiguration(classes = Main.class)
public class ImpUnitTests {

    @MockBean
    private PostService service;

    @MockBean
    private LikesService likesService;

    @Test
    public void shouldContainMainTitle() throws Exception{
        assertThat(service).isNotNull();
    }

    @Test
    public void shouldReturnListOfLikes() throws Exception{
        assertThat(service.listAllPosts()).isInstanceOf(List.class);
    }
}

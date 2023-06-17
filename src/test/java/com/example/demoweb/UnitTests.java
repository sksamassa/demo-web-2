package com.example.demoweb;

import com.example.demoweb.models.Post;
import com.example.demoweb.services.LikesService;
import com.example.demoweb.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;

@WebMvcTest(PostService.class)
public class UnitTests {
    @MockBean
    private PostService service;

    @Mock
    private LikesService likesService;
    @Test
    public void test() throws Exception{

        Post post = new Post(3L, "How's going your day?", new Date());
        service.addPosts(post);


        when(service.listAllPosts())
                .thenReturn(new ArrayList<Post>());

        when(likesService.like(post.getId()))
                .thenReturn(post.getLikes());

    }
}

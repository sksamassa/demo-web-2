package com.example.demoweb.services;

import com.example.demoweb.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final PostService postService;

    @Autowired
    public LikesService(PostService postService){
        this.postService = postService;
    }
    public int like(Long postId){
        Post post = postService.listAllPosts().get(postId.intValue());
        post.setLikes(post.getLikes() + 1);

        return post.getLikes();
    }
}

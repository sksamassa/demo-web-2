package com.example.demoweb.services;

import com.example.demoweb.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
   java.util.List<Post> posts = new ArrayList<>();
    public List<Post> listAllPosts(){
        return posts;
    }

    public void addPosts(Post post){
        posts.add(post);
    }

    public void create(String text) {
        posts.add(new Post(null, text, new Date()));
    }
}

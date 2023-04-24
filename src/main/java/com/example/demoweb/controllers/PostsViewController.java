package com.example.demoweb.controllers;

import com.example.demoweb.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostsViewController {
    @Autowired
    PostService postService;

    @RequestMapping(path = "/post", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("appName", "HELLO APP");
        model.addAttribute("posts", postService.listAllPosts());
        return "list";
    }

    @ResponseBody
    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    public String single(@PathVariable(value = "id", required = false) Long id) {
        return "Здесь будет страница поста №" + id;
    }
}

package com.example.demoweb.models;

import java.util.Date;

public class Post {
    private Long id;
    private String text;
    private Integer likes = 0;
    private Date creationDate;

    public Post() {
    }

    public Post(Long id, String text, Date creationDate) {
        this.id = id;
        this.text = text;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes){
        this.likes = likes;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}

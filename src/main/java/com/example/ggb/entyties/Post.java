package com.example.ggb.entyties;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "postGroup_id", nullable = false)
    private PostGroup postGroup;

    public Post() {
    }

    public Post(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post(PostGroup postGroup) {
        this.postGroup = postGroup;
    }

    public PostGroup getPostGroup() {
        return postGroup;
    }

    public void setPostGroup(PostGroup postGroup) {
        this.postGroup = postGroup;
    }
}

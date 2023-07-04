package com.example.ggb.services;

import com.example.ggb.entyties.Org;
import com.example.ggb.entyties.Post;
import com.example.ggb.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> listPosts(){
        return (List<Post>) postRepository.findAll();
    }
}

package com.example.ggb.services;

import com.example.ggb.entyties.Post;
import com.example.ggb.entyties.PostGroup;
import com.example.ggb.repositories.PostGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostGroupService {

    private PostGroupRepository postGroupRepository;

    public PostGroupService(PostGroupRepository postGroupRepository) {
        this.postGroupRepository = postGroupRepository;
    }

    public List<PostGroup> listPostGroups(){
        return (List<PostGroup>) postGroupRepository.findAll();
    }

}

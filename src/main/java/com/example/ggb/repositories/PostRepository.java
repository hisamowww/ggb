package com.example.ggb.repositories;

import com.example.ggb.entyties.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}

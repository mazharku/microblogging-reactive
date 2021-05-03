package com.mazhar.reactive.service;

import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.repository.PostRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class PostService {

    private PostRepository repository;
    PostService(PostRepository repository){
        this.repository = repository;
    }

    public Flux<BlogPost> getPosts() {
        Flux<BlogPost> posts = repository.findAll();
        return posts;
    }
}

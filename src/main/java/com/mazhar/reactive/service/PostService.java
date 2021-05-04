package com.mazhar.reactive.service;

import com.mazhar.reactive.exception.ResourceNotFound;
import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PostService {

    private PostRepository repository;
    private ModelMapper modelMapper;
    PostService(PostRepository repository, ModelMapper modelMapper){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public Flux<PostDTO> getPosts() {
        return repository.findAll().flatMap(e -> Mono.just(modelMapper.map(e, PostDTO.class)));
    }

    public Mono<PostDTO> getPostById(UUID id) throws ResourceNotFound{
        try {
        return repository.findById(id).flatMap(e -> {
            if(e==null) {
                return  Mono.error(new ResourceNotFound("hghg"));
            }
            return  Mono.just(modelMapper.map(e, PostDTO.class));
        });
        } catch (IllegalArgumentException ex) {
            String res = ex.toString();
            return Mono.empty();
        }
    }

    public Mono<Void> createPost(BlogPost post){
        repository.save(post);
        return Mono.empty();
    }

    public Flux<PostDTO> getPostsOfUser(UUID userId) {
        return repository.getPostByUser(userId).flatMap(e -> Mono.just(modelMapper.map(e, PostDTO.class)));
    }

}

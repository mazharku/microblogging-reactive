package com.mazhar.reactive.rest;

import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.service.PostService;
import com.mazhar.reactive.util.AppResponse;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "posts", produces = { "application/json" })
public class PostResource {

    private Logger log = LoggerFactory.getLogger(PostResource.class);
    private PostService service;

    @Autowired
    public void setBlogPostService(PostService service) {
        this.service = service;
    }

    @GetMapping("/")
    Publisher<?> getPosts() {
        return service.getPosts();
    }

    @GetMapping("/{post_id}")
    Publisher<?> getPostById(@PathVariable(name = "post_id") UUID postId) {
        try {
            Mono<PostDTO> postById = service.getPostById(postId);

            return  postById;
        } catch (Exception e ) {
            String f= e.getMessage();
            return Mono.just(AppResponse.operationFail(e.getMessage()));
        }

    }
}

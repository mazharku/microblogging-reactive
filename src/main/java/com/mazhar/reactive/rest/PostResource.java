package com.mazhar.reactive.rest;

import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.service.PostService;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "posts", produces = {"application/json"})
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
        return service.getPostById(postId);
    }

    @PostMapping("/")
    Publisher<?> createPost(@RequestBody BlogPost post) {
        return service.createPost(post);
    }

    @GetMapping("/user/{userid}")
    Publisher<?> getPostByUser(@PathVariable(name = "userid") UUID userid) {
        return service.getPostsOfUser(userid);
    }


    @DeleteMapping("/{id}")
    Publisher<?> deletePost(@PathVariable(name = "id") UUID id) {
        return deletePost(id);
    }

}

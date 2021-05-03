package com.mazhar.reactive.rest;

import com.mazhar.reactive.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    ResponseEntity<?> getPosts() {
        return new ResponseEntity<Object>(service.getPosts(), new HttpHeaders(), HttpStatus.OK);
    }
}

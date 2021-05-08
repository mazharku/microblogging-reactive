package com.mazhar.reactive.repository;

import com.mazhar.reactive.model.BlogPost;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface PostRepository extends ReactiveCrudRepository<BlogPost, UUID> {

    @Query(value = "SELECT * FROM blog_post WHERE blog_user_id =:userid")
    Flux<BlogPost> getPostByUser(@Param("userid") UUID userid);
}

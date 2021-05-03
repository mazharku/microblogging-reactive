package com.mazhar.reactive.repository;

import com.mazhar.reactive.model.BlogPost;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PostRepository extends ReactiveCrudRepository<BlogPost, UUID> {
}

/**
 * 
 */
package com.mazhar.reactive.repository;


import com.mazhar.reactive.model.BlogUser;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
public interface UserRespository extends ReactiveCrudRepository<BlogUser, UUID> {
    @Query(value = "SELECT * FROM blog_user WHERE email=:email")
    public Mono<BlogUser> getUserByMail(@Param("email") String email);
}

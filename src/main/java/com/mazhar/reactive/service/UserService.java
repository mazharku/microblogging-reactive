/**
 *
 */
package com.mazhar.reactive.service;

import com.mazhar.reactive.exception.ResourceNotFound;
import com.mazhar.reactive.model.BlogUser;
import com.mazhar.reactive.model.LoginRequest;
import com.mazhar.reactive.repository.UserRespository;
import com.mazhar.reactive.rest.BlogUserResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRespository repository;

    public Mono<BlogUser> createUser(BlogUser user)  {
       return repository.getUserByMail(user.getEmail()).hasElement().map(e -> {
            if(e.booleanValue()==true){
               return Mono.error(new ResourceNotFound("User Already Exists"));
            } else {
               user.setActive(true);
               return user;
            }
        }).then(repository.save(user));
    }

    public Mono<BlogUser> dologIn(LoginRequest request)  {
        return repository.getUserByMail(request.getEmail().trim()).map(e -> {
            if(e.getPassword().equals(request.getPassword())){
                return e;
            }
            else {
                return null;
            }
        });

    }

    public Mono<Boolean> dologout(UUID userId)  {
        return repository.findById(userId).doOnNext(e -> {
            e.setActive(false);
            repository.save(e).subscribe();
        }).thenReturn(true);
    }
}

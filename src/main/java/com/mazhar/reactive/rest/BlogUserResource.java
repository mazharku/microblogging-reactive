/**
 *
 */
package com.mazhar.reactive.rest;

import com.mazhar.reactive.model.BlogUser;
import com.mazhar.reactive.model.LoginRequest;
import com.mazhar.reactive.service.UserService;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "users", produces = {"application/json"})
public class BlogUserResource {
    private Logger log = LoggerFactory.getLogger(BlogUserResource.class);
    @Autowired
    private UserService service;

    @PostMapping("/registration")
    Publisher<?> createUser(@RequestBody BlogUser user) {
        return service.createUser(user);
    }

    @PostMapping("/login")
    Publisher<?> doLogIn(@RequestBody LoginRequest request) {
        return service.dologIn(request);
    }

    @PostMapping("/logout")
    Publisher<?> doLogout(@RequestParam(name = "user") UUID userId) {
        try {
            return service.dologout(userId);
        }
        catch (Exception e) {
            return Mono.error(e);
        }

    }
}

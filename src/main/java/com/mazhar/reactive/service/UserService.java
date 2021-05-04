/**
 *
 */
package com.mazhar.reactive.service;

import com.mazhar.reactive.exception.ResourceNotFound;
import com.mazhar.reactive.model.BlogUser;
import com.mazhar.reactive.model.LoginRequest;
import com.mazhar.reactive.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Service
public class UserService {

    @Autowired
    private UserRespository repository;

    public boolean createUser(BlogUser user) throws Exception {
        /*Optional<BlogUser> existenceUser = repository.getUserByMail(user.getEmail().trim());
        if (existenceUser.isPresent())
            throw new Exception("User Exists with same credentials, try with different email!");
        else {
            user.setActive(true);
            repository.save(user);
        }*/
        return true;
    }

    public BlogUser dologIn(LoginRequest request) throws Exception {
       /* BlogUser user = repository.getUserByMail(request.getEmail().trim()).orElseThrow(() -> new ResourceNotFound("No Valid User Find"));
        if (user.getPassword().equals(request.getPassword())) {
            user.setActive(true);
            repository.save(user);
            return user;
        }
        else
            throw new Exception("Password does not match, try with right password");*/
            return null;
    }

    public boolean dologout(UUID userId) throws Exception {
        return false;
    }
}

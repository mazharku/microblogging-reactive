/**
 * 
 */
package com.mazhar.reactive.rest;

import com.mazhar.reactive.model.BlogUser;
import com.mazhar.reactive.model.LoginRequest;
import com.mazhar.reactive.service.UserService;
import com.mazhar.reactive.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.mazhar.reactive.util.AppConstant.ROOT_PATH;

/**
 * @author mazhar
 *
 */
@CrossOrigin
@RestController
@RequestMapping(path = ROOT_PATH + "users", produces = { "application/json" })
public class BlogUserResource {
	private Logger log = LoggerFactory.getLogger(BlogUserResource.class);
	@Autowired
	private UserService service;
	
	@PostMapping("/registration")
	ResponseEntity<?> createUser(@RequestBody BlogUser user) {
		try {
			service.createUser(user);
			return new ResponseEntity<Object>(AppResponse.resourceCreated(), new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}
	@PostMapping("/login")
	ResponseEntity<?> doLogIn(@RequestBody LoginRequest request) {
		try {
			BlogUser user = service.dologIn(request);
			return new ResponseEntity<Object>(user, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(AppResponse.operationFail(e.getMessage()), new HttpHeaders(),
					HttpStatus.OK);
		}
	}

	@PostMapping("/logout")
	ResponseEntity<?> doLogout(@RequestParam(name="user") UUID userId) {
		try {
			service.dologout(userId);
			return new ResponseEntity<Object>(true, new HttpHeaders(), HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<Object>(false, new HttpHeaders(),
					HttpStatus.OK);
		}
	}
}

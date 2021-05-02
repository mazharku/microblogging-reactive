/**
 * 
 */
package com.mazhar.reactive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author mazhar
 *
 * Mar 23, 2021
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception {
	public ResourceNotFound() {
        super();
    }
    public ResourceNotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public ResourceNotFound(String message) {
        super(message);
    }
    public ResourceNotFound(Throwable cause) {
        super(cause);
    }
}

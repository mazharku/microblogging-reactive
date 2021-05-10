/**
 * 
 */
package com.mazhar.reactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class BlogUser extends Auditable<UUID> {
	@Id
	private UUID blogUserId;
	private String email;
	private String blogUserName;
	private String password;
	private String gender;
	private Date dob;
	private boolean isActive;
	
}

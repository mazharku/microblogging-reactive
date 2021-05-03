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
	private UUID id;
	private String email;
	private String userName;
	private String password;
	private String gender;
	private Date dob;
	private boolean isActive;
	
}

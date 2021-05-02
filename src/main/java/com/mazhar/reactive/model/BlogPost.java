/**
 * 
 */
package com.mazhar.reactive.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class BlogPost extends Auditable<UUID>{
	private UUID id;
	private String title;
	private String post;
	private BlogUser user;
	private Set<Comment> comments;
	private Set<Vote> votes;
}

/**
 * 
 */
package com.mazhar.reactive.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
@Data
@Table(value = "blog_post")
public class BlogPost extends Auditable<UUID>{
	private UUID id;
	private String title;
	private String post;
	private UUID blogUserId;
}

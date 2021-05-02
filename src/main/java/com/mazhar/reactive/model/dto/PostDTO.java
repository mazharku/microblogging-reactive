/**
 * 
 */
package com.mazhar.reactive.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class PostDTO {

	private UUID id;
	private String userName;
	private UUID userId;
	private String title;
	private String post;
	private List<CommentDTO> comments;
}

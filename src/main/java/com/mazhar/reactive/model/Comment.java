/**
 *
 */
package com.mazhar.reactive.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class Comment extends Auditable<UUID> {
    @Id
    private UUID commentId;
    private String comment;
    private UUID commenterId;
    private UUID postId;
}

/**
 *
 */
package com.mazhar.reactive.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class Comment extends Auditable<UUID> {

    private UUID id;
    private String comment;
    private BlogUser commenterName;
    private BlogPost post;
}

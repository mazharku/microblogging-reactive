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
public class Vote extends Auditable<UUID> {
    @Id
    private UUID voteId;
    private UUID voterId;
    private UUID postId;
    private boolean vote;
}

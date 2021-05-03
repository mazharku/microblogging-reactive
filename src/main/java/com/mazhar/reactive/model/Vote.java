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
public class Vote extends Auditable<UUID> {
    private UUID id;
    private UUID voterId;
    private UUID postId;
    private boolean vote;
}

/**
 * 
 */
package com.mazhar.reactive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * @author mazhar
 *
 * Mar 22, 2021
 */
@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public abstract class Auditable<UUID> {
	

    protected UUID createdBy;

    @CreatedDate
    protected Date createdOn;


    @LastModifiedBy
    protected UUID updatedBy;

    @LastModifiedDate
    protected Date updatedOn;
  
}


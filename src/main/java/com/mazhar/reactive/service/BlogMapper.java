package com.mazhar.reactive.service;

import com.mazhar.reactive.model.BlogPost;
import com.mazhar.reactive.model.Comment;
import com.mazhar.reactive.model.Vote;
import com.mazhar.reactive.model.dto.CommentDTO;
import com.mazhar.reactive.model.dto.PostDTO;
import com.mazhar.reactive.model.dto.VoteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BlogMapper {

    @Mapping(source = "blogUserId", target = "userId")
    PostDTO postToPostDto(BlogPost post);

    CommentDTO commentToDto(Comment comment);

    VoteDTO voteToDto(Vote vote);
}

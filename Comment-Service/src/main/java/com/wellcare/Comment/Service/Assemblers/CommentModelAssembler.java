package com.wellcare.Comment.Service.Assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.wellcare.Comment.Service.Controllers.CommentController;
import com.wellcare.Comment.Service.Exceptions.CommentException;
import com.wellcare.Comment.Service.Models.Comment;

@Component
public class CommentModelAssembler implements RepresentationModelAssembler<Comment, EntityModel<Comment>> {

    @Override
    public EntityModel<Comment> toModel(Comment comment) {

        try {
            return EntityModel.of(comment,
                    linkTo(methodOn(CommentController.class).toggleLikeComment(comment.getId(),
                            comment.getUserid())).withRel("toggleLike"));
        } catch (CommentException e) {
            e.printStackTrace();
            return EntityModel.of(comment);
        }
    }

}
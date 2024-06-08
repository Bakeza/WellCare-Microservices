package com.wellcare.Post.Service.Assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.wellcare.Post.Service.Controllers.PostController;
import com.wellcare.Post.Service.Models.Post;

@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {

    @Override
    public EntityModel<Post> toModel(Post post) {

        return EntityModel.of(
                post,
                linkTo(methodOn(PostController.class).getPostsByUserId(post.getUserid(), null)).withRel("allPosts"));

    }

}
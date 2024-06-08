package com.wellcare.Post.Service.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wellcare.Post.Service.Models.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.userid = :userId order by p.createdAt desc")
    public Page<Post> findByUserId(@Param("userId") Long userId, Pageable pageable);

    @Query("SELECT COUNT(p) FROM Post p WHERE p.userid = :userId")
    Long countPostsByUserId(@Param("userId") Long userId);

    @Query("SELECT p FROM Post p WHERE p.userid IN :userIds order by p.createdAt desc")
    Page<Post> findAllPostsByUserIds(List<Long> userIds, Pageable pageable);

//    @Query("SELECT DISTINCT p FROM Post p LEFT JOIN FETCH p.likes LEFT JOIN FETCH p.comments order by p.createdAt desc")
//    Page<Post> findAllWithLikesAndComments(Pageable pageable);
}

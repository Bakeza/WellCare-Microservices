package com.wellcare.Comment.Service.Repositories;

import java.util.Optional;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellcare.Comment.Service.Models.CommentLike;

@Repository

public interface CommentlikeRepository extends JpaRepository<CommentLike, Long> {
    @Query("SELECT cl FROM CommentLike cl WHERE cl.comment.id = :commentId AND cl.userId = :userId")
    Optional<CommentLike> findByCommentIdAndUserId(Long commentId, Long userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM CommentLike cl WHERE cl.comment.id = :commentId")
    void deleteCommentLikesByCommentId(@Param("commentId") Long commentId);

}

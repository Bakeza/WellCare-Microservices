package com.wellcare.Comment.Service.Models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String attachment;

    private long userid;

    private long noOfLikes;

    private long postid;
    @Size(max = 500, message = "Content length must be less than or equal to 500 characters")
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "comment")
    @JsonIgnoreProperties("comment")
    private Set<CommentLike> commentLikes = new HashSet<>();

    @AssertTrue(message = "Either attachment or content must be provided")
    public boolean isEitherAttachmentOrContentValid() {
        if (content == null || content.isBlank()) {
            return attachment == null || attachment.isBlank();
        } else {
            return true;
        }
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getPostid() {
        return postid;
    }

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(long noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public Set<CommentLike> getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(Set<CommentLike> commentLikes) {
        this.commentLikes = commentLikes;
    }

    public Comment() {
    }

    public Comment(String content) {

        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.noOfLikes = 0;
    }

    public Comment(String content, String attachment) {

        this.content = content;
        this.attachment = attachment;
        this.createdAt = LocalDateTime.now();
        this.noOfLikes = 0;
    }

}

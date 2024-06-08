package com.wellcare.User.Service.Models;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Data
@Table(name = "user_friends")
public class UserFriends {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long friend_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(Long friend_id) {
        this.friend_id = friend_id;
    }
    public UserFriends() {

    }
    public UserFriends(Long id, User user, Long friend_id) {
        this.id = id;
        this.user = user;
        this.friend_id = friend_id;
    }
}
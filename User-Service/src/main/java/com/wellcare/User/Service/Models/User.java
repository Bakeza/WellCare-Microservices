package com.wellcare.User.Service.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(groups = { Create.class })
    @Size(min = 6, message = "Username should have at least 6 characters")
    private String username;

    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;

    @NotNull(groups = { Create.class })
    @Size(min = 8, message = "Password should have at least 8 characters")
    @JsonIgnore
    private String password;

    @Email(message = "Please enter a valid email address")
    private String email;

    private String mobile;
    private String bio;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String image;

    private String attachment;
    private String degree;
    private String specialty;

    @Enumerated(EnumType.STRING)
    private ERole role;

    @NotNull
    @Min(0)
    private Integer friendsNumber = 0;

    @NotNull
    @Min(0)
    private Integer postsCount = 0;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<UserFriends> friends = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(groups = {
            Create.class }) @Size(min = 6, message = "Username should have at least 6 characters") String getUsername() {
        return username;
    }

    public void setUsername(@NotNull(groups = {
            Create.class }) @Size(min = 6, message = "Username should have at least 6 characters") String username) {
        this.username = username;
    }

    public @Size(min = 2, message = "Name should have at least 2 characters") String getName() {
        return name;
    }

    public void setName(@Size(min = 2, message = "Name should have at least 2 characters") String name) {
        this.name = name;
    }

    public @NotNull(groups = {
            Create.class }) @Size(min = 8, message = "Password should have at least 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotNull(groups = {
            Create.class }) @Size(min = 8, message = "Password should have at least 8 characters") String password) {
        this.password = password;
    }

    public @Email(message = "Please enter a valid email address") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Please enter a valid email address") String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    public @NotNull @Min(0) Integer getFriendsNumber() {
        return friendsNumber;
    }

    public void setFriendsNumber(@NotNull @Min(0) Integer friendsNumber) {
        this.friendsNumber = friendsNumber;
    }

    public @NotNull @Min(0) Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(@NotNull @Min(0) Integer postsCount) {
        this.postsCount = postsCount;
    }

    public List<UserFriends> getFriends() {
        return friends;
    }

    public void setFriends(List<UserFriends> friends) {
        this.friends = friends;
    }

    public void addFriend(UserFriends friend) {
        if (!this.friends.contains(friend)) {
            this.friends.add(friend);
            friendsNumber++;

        }
    }

    public void removeFriend(User friend) {
        this.friends.remove(friend);
        friend.getFriends().remove(this);
        friendsNumber--;
    }

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String name, String password, String email, ERole role) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(
            String username,
            String name,
            String password,
            String email, String attachment, String degree,
            String specialty, ERole role) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.attachment = attachment;
        this.degree = degree;
        this.specialty = specialty;
        this.role = role;
    }

    public void incrementFriendsNumber() {
        this.friendsNumber++;
    }

    public void decrementFriendsNumber() {
        this.friendsNumber--;
        if (this.friendsNumber < 0) {
            this.friendsNumber = 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        if (ERole.PATIENT.equals(role)) {
            return "User [id=" + id + ", username=" + username + ", name=" + name
                    + ", email=" + email + ", mobile=" + mobile + ", bio=" + bio + ", gender="
                    + gender + ", image=" + image + ", role=" + role + "]";
        } else {
            return "User [id=" + id + ", username=" + username + ", name=" + name
                    + ", email=" + email + ", mobile=" + mobile + ", bio=" + bio + ", gender="
                    + gender + ", image=" + image + ", attachment=" + attachment + ", degree=" + degree + ", specialty="
                    + specialty
                    + ", role=" + role + "]";
        }
    }

    public interface Create extends Default {
    }

}

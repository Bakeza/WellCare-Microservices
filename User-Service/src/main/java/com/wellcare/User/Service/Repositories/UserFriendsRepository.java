package com.wellcare.User.Service.Repositories;

import com.wellcare.User.Service.Models.UserFriends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserFriendsRepository extends JpaRepository<UserFriends, Long> {
    @Query("SELECT uf.friend_id FROM UserFriends uf WHERE uf.user.id = :user_id")
    List<Long> findAllFriendIdsByUserId(@Param("user_id") Long user_id);
}

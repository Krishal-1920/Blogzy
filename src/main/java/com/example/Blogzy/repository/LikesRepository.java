package com.example.Blogzy.repository;

import com.example.Blogzy.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesRepository extends JpaRepository<Likes, String> {

    boolean existsByUsersUserIdAndFeedFeedId(String usersId, String feedId);
}

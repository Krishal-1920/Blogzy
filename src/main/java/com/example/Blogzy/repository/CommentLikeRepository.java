package com.example.Blogzy.repository;

import com.example.Blogzy.entity.CommentLike;
import com.example.Blogzy.entity.Comments;
import com.example.Blogzy.entity.Replies;
import com.example.Blogzy.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, String> {


    int countByComment(Comments comment);

    int countByReply(Replies reply);

    boolean existsByUserAndComment(Users user, Comments comment);

    boolean existsByUserAndReply(Users user, Replies reply);
}

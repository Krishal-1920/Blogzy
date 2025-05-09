package com.example.Blogzy.repository;

import com.example.Blogzy.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, String> {
}

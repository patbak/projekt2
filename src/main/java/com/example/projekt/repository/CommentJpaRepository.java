package com.example.projekt.repository;

import com.example.projekt.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {
}

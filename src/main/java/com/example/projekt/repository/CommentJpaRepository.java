package com.example.projekt.repository;

import com.example.projekt.model.Comment;
import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByUser(User user);

}

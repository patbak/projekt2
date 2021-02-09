package com.example.projekt.service;

import com.example.projekt.entity.CommentsDto;
import com.example.projekt.entity.Engineer;
import com.example.projekt.model.Comment;
import com.example.projekt.repository.CommentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentJpaRepository commentJpaRepository;
    @Autowired
    private EngineerService engineerService;

    public List<CommentsDto> getComments(){
        List<Comment> comments = commentJpaRepository.findAll();
        List<CommentsDto>  commentsDtoList = new ArrayList<>();
        for(Comment comment:comments){
            Engineer engineer = engineerService.setEngineer(comment.getUser());
            CommentsDto commentsDto = new CommentsDto(
                    comment.getIdComment(),
                    comment.getText(),
                    comment.getCommentNumber(),
                    engineer
            );
        commentsDtoList.add(commentsDto);
        }
        return commentsDtoList;
    }

}

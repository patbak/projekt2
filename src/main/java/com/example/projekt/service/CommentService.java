package com.example.projekt.service;

import com.example.projekt.dto.CommentsCommandDto;
import com.example.projekt.dto.CommentsDto;
import com.example.projekt.dto.Engineer;
import com.example.projekt.model.BuildingDailyReports;
import com.example.projekt.model.Comment;
import com.example.projekt.model.User;
import com.example.projekt.repository.BuildingDailyReportsJpaRepository;
import com.example.projekt.repository.CommentJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
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
    @Autowired
    private BuildingDailyReportsJpaRepository buildingDailyReportsJpaRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;

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

    public CommentsDto setComment(Comment comment){
        Engineer engineer = engineerService.setEngineer(comment.getUser());
        CommentsDto commentsDto = new CommentsDto(
                comment.getIdComment(),
                comment.getText(),
                comment.getCommentNumber(),
                engineer
        );
        return  commentsDto;
    }

    public void createComment(int id, CommentsCommandDto commentsCommandDto){
        BuildingDailyReports buildingDailyReports = buildingDailyReportsJpaRepository.getOne(id);
        User user = userJpaRepository.getOne(commentsCommandDto.getUserId());
        Comment comment = new Comment(
                commentsCommandDto.getCommentNumber(),
                commentsCommandDto.getComment(),
                buildingDailyReports,
                user
        );
        commentJpaRepository.saveAndFlush(comment);
    }
}

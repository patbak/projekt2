package com.example.projekt.controller;

import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.CommentsDto;
import com.example.projekt.service.BrigadeDailyReportService;
import com.example.projekt.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/Comments")
    public List<CommentsDto> getComments(){

        List<CommentsDto> commentsDtoList = commentService.getComments();
        return commentsDtoList;
    }
}

package com.example.projekt.controller;

import com.example.projekt.entity.CommentsDto;
import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.service.CommentService;
import com.example.projekt.service.DoneWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoneWorkController {

    @Autowired
    private DoneWorkService doneWorkService;

    @GetMapping("/done-works")
    public List<DoneWorkDto> getDoneWorks(){

        List<DoneWorkDto> doneWorkDtoList = doneWorkService.getDoneWork();
        return doneWorkDtoList;
    }
}

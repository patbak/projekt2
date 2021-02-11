package com.example.projekt.controller;

import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.WorkCardDto;
import com.example.projekt.service.DoneWorkService;
import com.example.projekt.service.WorkCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkCardController {

    @Autowired
    private WorkCardService workCardService;

    @GetMapping("/WorkCards")
    public List<WorkCardDto> getWorkCards(){

        List<WorkCardDto> workCardDtoList = workCardService.getWorkCards();
        return workCardDtoList;
    }

}

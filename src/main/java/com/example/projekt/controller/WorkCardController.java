package com.example.projekt.controller;

import com.example.projekt.dto.WorkCardDto;
import com.example.projekt.service.WorkCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkCardController {

    @Autowired
    private WorkCardService workCardService;

    @GetMapping("/work-cards")
    public List<WorkCardDto> getWorkCards(){

        List<WorkCardDto> workCardDtoList = workCardService.getWorkCards();
        return workCardDtoList;
    }

}

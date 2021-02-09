package com.example.projekt.controller;

import com.example.projekt.entity.DoneWorkDto;
import com.example.projekt.entity.WeatherConditionsDto;
import com.example.projekt.model.WeatherConditions;
import com.example.projekt.service.DoneWorkService;
import com.example.projekt.service.WeatherConditionsDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherConditionsController {

    @Autowired
    private WeatherConditionsDtoService weatherConditionsDtoService;

    @GetMapping("/getWeatherConditions")
    public List<WeatherConditionsDto> getDoneWorks(){

        List<WeatherConditionsDto> weatherConditionsList = weatherConditionsDtoService.getWeatherConditions();
        return weatherConditionsList;
    }

}

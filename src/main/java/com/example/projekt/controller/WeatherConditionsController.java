package com.example.projekt.controller;

import com.example.projekt.dto.WeatherConditionsDto;
import com.example.projekt.service.WeatherConditionsDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WeatherConditionsController {

    @Autowired
    private WeatherConditionsDtoService weatherConditionsDtoService;

    @GetMapping("/weather-conditions")
    public List<WeatherConditionsDto> getDoneWorks(){

        List<WeatherConditionsDto> weatherConditionsList = weatherConditionsDtoService.getWeatherConditions();
        return weatherConditionsList;
    }

}

package com.example.projekt.service;

import com.example.projekt.entity.WeatherConditionsDto;
import com.example.projekt.model.WeatherConditions;
import com.example.projekt.repository.WeatherConditionsJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherConditionsDtoService {

    @Autowired
    private WeatherConditionsJpaRepository weatherConditionsJpaRepository;

    public List<WeatherConditionsDto> getWeatherConditions(){
        List<WeatherConditions> weatherConditionsList = weatherConditionsJpaRepository.findAll();
        List<WeatherConditionsDto> weatherConditionsDtoList = new ArrayList<>();
        for(WeatherConditions weatherConditions:weatherConditionsList){
            WeatherConditionsDto weatherConditionsDto = setWeatherCondition(weatherConditions);
            weatherConditionsDtoList.add(weatherConditionsDto);
        }
        return  weatherConditionsDtoList;
    }

    public WeatherConditionsDto setWeatherCondition(WeatherConditions weatherConditions){
        WeatherConditionsDto weatherConditionsDto = new WeatherConditionsDto(
                weatherConditions.getIdWeatherCondition(),
                weatherConditions.getWeatherCondition()
        );
        return weatherConditionsDto;
    }

}

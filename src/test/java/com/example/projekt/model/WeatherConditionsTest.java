package com.example.projekt.model;

import com.example.projekt.repository.WeatherConditionsJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class WeatherConditionsTest {

    @Autowired
    private WeatherConditionsJpaRepository repository;

    @Test
    @Transactional
    public void getWeatherConditionsTest()throws Exception{

        List<WeatherConditions> weatherConditions = repository.findAll();
        for(WeatherConditions weatherCondition : weatherConditions){
            System.out.println(weatherCondition.getIdWeatherCondition()+" "+weatherCondition.getWeatherCondition());
          List<BuildingDailyReports> buildingDailyReports =  weatherCondition.getBuildingDailyReportsList();
          for(BuildingDailyReports buildingDailyReport : buildingDailyReports){
              ConstructionSite constructionSite = buildingDailyReport.getConstructionSite();
              System.out.println(buildingDailyReport.getReportDate()+" "+buildingDailyReport.getIdBuildingDailyReport()
              +constructionSite.getName()+" "+constructionSite.getBuildingNumber()+" "+constructionSite.getCoordinates()
              );


          }
        }
    }

    @Test
    @Transactional
    public void getRandomWeatherConditionsTest()throws Exception{

        List<WeatherConditions> weatherConditions = repository.findAll();
        int min= 0;
        int max = weatherConditions.size();
        for (int j=0;j<10;j++){
            int number= (int) ((Math.random() * (max - min)) + min);
            System.out.println(number);
            WeatherConditions weatherCondition = weatherConditions.get(number);
            System.out.println(weatherCondition.getIdWeatherCondition());
            System.out.println(weatherCondition.getWeatherCondition());
        }

    }

}

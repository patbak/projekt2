package com.example.projekt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuildingServiceTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    public void testBuildingService(){
        buildingService.getBuildings();
    }

}

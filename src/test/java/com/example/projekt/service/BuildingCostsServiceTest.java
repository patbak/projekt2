package com.example.projekt.service;

import com.example.projekt.model.Costs;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.repository.CostsJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BuildingCostsServiceTest {

    @Autowired
    private CostsJpaRepository costsJpaRepository;
    @Autowired
    private BuildingCostsService buildingCostsService;


    @Test
    public void getCoststest(){
        List<Costs> costsList = costsJpaRepository.findAll();
        assertTrue(costsList.size()>0);
    }

    @Test
    public void getMaterialCosts(){
     // buildingCostsService.countMaterialCosts();

    }

    @Test
    public void getWorkersCosts(){
       // buildingCostsService.countWorkersCosts();
    }
}

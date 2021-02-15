package com.example.projekt.model;

import com.example.projekt.repository.CostsJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class CostsTest {

    @Autowired
    private CostsJpaRepository costsJpaRepository;


    @Test
    @Transactional
    public void getCostsByConstructionSiteId()throws Exception{

        List<Costs> costsList = costsJpaRepository.findAllByConstructionSite_ConstructionSiteIdOrderByDateDesc(3);

        for(int i=0;i<costsList.size();i++){
            System.out.println(costsList.get(i).getId());
            System.out.println(costsList.get(i).getDate());
            System.out.println(costsList.get(i).getEquipmentCost());
            System.out.println(costsList.get(i).getMaterialCost());
            System.out.println(costsList.get(i).getWorkersCost());
            System.out.println(costsList.get(i).getMonthlyCost());
            System.out.println(costsList.get(i).getTotalCost());
        }
        System.out.println(costsList.get(0).getTotalCost());

    }

}

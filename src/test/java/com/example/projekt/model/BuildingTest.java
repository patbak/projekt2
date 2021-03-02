package com.example.projekt.model;

import com.example.projekt.repository.ConstructionSiteJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BuildingTest {

    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;

    @Test
    @Transactional
    public void getFinishedBuildings()throws Exception{
        List<ConstructionSite>  constructionSiteList = constructionSiteJpaRepository.findAllByIsActive(false);
        System.out.println(constructionSiteList.size());
        for (ConstructionSite constructionSite:constructionSiteList){
            System.out.println(constructionSite.getConstructionSiteId());
            System.out.println(constructionSite.getName());
            System.out.println(constructionSite.getCoordinates());
            System.out.println(constructionSite.getActive());
        }
        assertTrue(constructionSiteList.size()>0);
    }

    @Test
    @Transactional
    public void getActiveBuildings()throws Exception{
        List<ConstructionSite>  constructionSiteList = constructionSiteJpaRepository.findAllByIsActive(true);
        System.out.println(constructionSiteList.size());
        for (ConstructionSite constructionSite:constructionSiteList){
            System.out.println(constructionSite.getConstructionSiteId());
            System.out.println(constructionSite.getName());
            System.out.println(constructionSite.getCoordinates());
            System.out.println(constructionSite.getActive());
        }
        assertTrue(constructionSiteList.size()>0);
    }

}

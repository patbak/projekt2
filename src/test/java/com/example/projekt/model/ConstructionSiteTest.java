package com.example.projekt.model;
import com.example.projekt.repository.ConstructionSiteJpaRepository;
import com.example.projekt.repository.ConstructionSiteRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ConstructionSiteTest {

    @Autowired
    private ConstructionSiteJpaRepository constructionSiteJpaRepository;



    @Test
    @Transactional
    public void getConstructionSiteTest()throws Exception{

        ConstructionSite constructionSite = constructionSiteJpaRepository.getOne(1);
        System.out.println(constructionSite.getName());
        System.out.println(constructionSite.getBuildingNumber());
        System.out.println(constructionSite.getCoordinates());
        System.out.println(constructionSite.getPlannedEndDate());
        System.out.println(constructionSite.getPlannedStartDate());
        Set<User> users = new HashSet<User>();
        users=constructionSite.getUsers();
        for(User user : users){
            System.out.println(user.getName());
            System.out.println(user.getLastName());
            System.out.println(user.getLogin());
            System.out.println(user.getEmail());

        }
    }

    @Test
    @Transactional
    public void getReportsByConstructionSite()throws Exception {

        ConstructionSite constructionSite = constructionSiteJpaRepository.getOne(1);
        System.out.println(constructionSite.getName());
        List<DailyWorkReport> dailyWorkReports = constructionSite.getDailyWorkReport();

        for (int i=0;i<dailyWorkReports.size();i++){
            DailyWorkReport dailyWorkReport = dailyWorkReports.get(i);
            System.out.println(dailyWorkReport.getReportDate());
            System.out.println(dailyWorkReport.getReportNumber());
        }



    }







}

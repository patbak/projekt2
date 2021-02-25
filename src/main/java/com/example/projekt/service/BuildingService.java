package com.example.projekt.service;

import com.example.projekt.dto.*;
import com.example.projekt.model.*;
import com.example.projekt.repository.ConstructionSiteJpaRepository;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BuildingService {

    @Autowired
    private ConstructionSiteJpaRepository repository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private EngineerService engineerService;
    @Autowired
    private BuildingDailyReportDtoService buildingDailyReportDtoService;

    public List<BuildingDto>  getBuildings(){
        List<ConstructionSite> constructionSites = repository.findAll();
        List<BuildingDto> buildingDtoList = new ArrayList<>();
        for (ConstructionSite constructionSite:constructionSites){
           BuildingDto buildingDto = setBuilding(constructionSite);
            buildingDtoList.add(buildingDto);
        }
    return buildingDtoList;
    }

    public BuildingDto getBuildingById(int id) {

        ConstructionSite constructionSite = repository.getOne(id);
        BuildingDto buildingDto = setBuilding(constructionSite);
        return buildingDto;
    }


    public BuildingDto setBuilding(ConstructionSite constructionSite){
        Set<User> users = constructionSite.getUsers();
        List<Engineer> engineers = new ArrayList<>();
        Engineer supervisor = new Engineer();
        Engineer engineer = new Engineer();
        for(User user:users){
            Set<Role> roles = user.getRoles();
            for (Role role:roles){
                if(role.getName().equals("ENGINEER")){
                    engineer = engineerService.setEngineer(user);
                    engineers.add(engineer);
                }else{
                    engineer = engineerService.setEngineer(user);
                    supervisor=engineer;
                }
            }
        }

        BuildingDto buildingDto = new BuildingDto(
                constructionSite.getConstructionSiteId(),
                constructionSite.getBuildingNumber(),
                constructionSite.getName(),
                constructionSite.getCoordinates(),
                constructionSite.getPlannedStartDate(),
                constructionSite.getRealStartDate(),
                constructionSite.getPlannedEndDate(),
                constructionSite.getRealEndDate(),
                engineers,
                supervisor

        );
        return  buildingDto;
    }

    public void saveBuilding(BuildingCommandDto buildingCommandDto){
        List<Integer> engineerList = buildingCommandDto.getEngineersIds();
        Set<User> users = new HashSet<>();
        User supervisor = userJpaRepository.getOne(buildingCommandDto.getSupervisorId());
        users.add(supervisor);
        for(Integer integer: engineerList){
            User user = userJpaRepository.getOne(integer.intValue());
            users.add(user);
        }
        ConstructionSite constructionSite = new ConstructionSite(
                buildingCommandDto.getName(),
                buildingCommandDto.getBuildingNumber(),
                buildingCommandDto.getCoordinates(),
                buildingCommandDto.getPlannedStartDate(),
                buildingCommandDto.getPlannedEndDate(),
                buildingCommandDto.getRealEndDate(),
                buildingCommandDto.getRealStartDate(),
                true,
                users

        );

        repository.saveAndFlush(constructionSite);
    }

    public List<Engineer> getEngineersFromBuilding(int id){
        ConstructionSite constructionSite = repository.getOne(id);
        Set<User> users = constructionSite.getUsers();
        List<Engineer> engineerList = new ArrayList<>();
        for (User user:users){
            Engineer engineer = engineerService.setEngineer(user);
            engineerList.add(engineer);
        }
        return engineerList;
    }

    public void addEngineerToBuilding(int id, EngineerCommandDto engineerCommandDto){
        ConstructionSite constructionSite = repository.getOne(id);
        Set<User> users = constructionSite.getUsers();
        User user = userJpaRepository.getOne(engineerCommandDto.getUserId());
        users.add(user);
        constructionSite.setUsers(users);
        repository.saveAndFlush(constructionSite);
    }

    public List<BuildingDto> getBuildingsByActive(Boolean bool){
        List<ConstructionSite> constructionSiteList = repository.findAllByIsActive(bool);
        List<BuildingDto> buildingDtoList =new ArrayList<>();
        for(ConstructionSite constructionSite:constructionSiteList){
            BuildingDto buildingDto = setBuilding(constructionSite);
            buildingDtoList.add(buildingDto);
        }
        return  buildingDtoList;
    }

    public List<BuildingDailyReportsDto> getBuildingReports(int id){
        ConstructionSite constructionSite = repository.getOne(id);
        List<BuildingDailyReports> buildingDailyReports = constructionSite.getBuildingDailyReports();
        List<BuildingDailyReportsDto> buildingDailyReportsDtoList = new ArrayList<>();
        for (BuildingDailyReports buildingDailyReport:buildingDailyReports){
            BuildingDailyReportsDto buildingDailyReportsDto = buildingDailyReportDtoService.setBuildingReport(buildingDailyReport);
            buildingDailyReportsDtoList.add(buildingDailyReportsDto);
        }
        return buildingDailyReportsDtoList;

    }





}

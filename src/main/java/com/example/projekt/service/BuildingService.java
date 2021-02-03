package com.example.projekt.service;

import com.example.projekt.entity.BuildingDto;
import com.example.projekt.entity.Engineer;
import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.Role;
import com.example.projekt.model.User;
import com.example.projekt.repository.ConstructionSiteJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class BuildingService {

    @Autowired
    private ConstructionSiteJpaRepository repository;

    public List<BuildingDto>  getBuildings(){
        List<ConstructionSite> constructionSites = repository.findAll();
        List<BuildingDto> buildingDtoList = new ArrayList<>();
        for (ConstructionSite constructionSite:constructionSites){
            Set<User> users = constructionSite.getUsers();
            List<Engineer> engineers = new ArrayList<>();
            Engineer supervisor = new Engineer();
            Engineer engineer = new Engineer();
            for(User user:users){
              Set<Role> roles = user.getRoles();
              for (Role role:roles){
                  if(role.getName().equals("ENGINEER")){
                       engineer = setEngineer(user);
                      engineers.add(engineer);
                  }else{
                       engineer = setEngineer(user);
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
            buildingDtoList.add(buildingDto);
        }
    return buildingDtoList;
    }

    public Engineer setEngineer(User user){
        Engineer engineer= new Engineer(
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getLogin(),
                user.getPhoneNumber(),
                user.getPermissionNumber()
        );
        return  engineer;
    }

}

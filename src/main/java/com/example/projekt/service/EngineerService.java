package com.example.projekt.service;

import com.example.projekt.entity.Engineer;
import com.example.projekt.model.User;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngineerService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<Engineer> getEngineers(){
        List<User> users = userJpaRepository.findAll();
        List<Engineer> engineerList = new ArrayList<>();
        for(User user:users){
            Engineer engineer = setEngineer(user);
            engineerList.add(engineer);
        }
        return engineerList;
    }


    public Engineer setEngineer(User user){
        Engineer engineer= new Engineer(
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getLogin(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getPermissionNumber()
        );
        return  engineer;
    }


}

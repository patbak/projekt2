package com.example.projekt.service;

import com.example.projekt.entity.Engineer;
import com.example.projekt.entity.RoleDto;
import com.example.projekt.model.Role;
import com.example.projekt.model.User;
import com.example.projekt.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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


/*
    public Engineer setEngineer(User user){
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getName()));

        }
        Engineer engineer= new Engineer(
                user.getUserId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getLogin(),
                user.getPhoneNumber(),
                user.getPassword(),
                user.getPermissionNumber(),
                authorities
        );
        System.out.println(engineer.getRoles().get(0).getAuthority());
        return  engineer;
    }
*/
public Engineer setEngineer(User user){
    Set<Role> roles = user.getRoles();
    List<RoleDto> roleList = new ArrayList<>();
    for(Role role : roles){
        RoleDto roleDto = new RoleDto(role.getId(),role.getName());
        roleList.add(roleDto);

    }
    Engineer engineer= new Engineer(
            user.getUserId(),
            user.getName(),
            user.getLastName(),
            user.getEmail(),
            user.getLogin(),
            user.getPhoneNumber(),
            user.getPassword(),
            user.getPermissionNumber(),
            roleList
    );
    return  engineer;
}

}

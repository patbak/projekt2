package com.example.projekt.model;

import com.example.projekt.repository.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    @Transactional
    public void getUsersTest()throws Exception{
        List<User> users = userJpaRepository.findAll();

        User user = users.get(1);

        Set<ConstructionSite> constructionSites = new HashSet<ConstructionSite>();
        constructionSites = user.getConstructionSites();

        for(ConstructionSite constructionSite : constructionSites){
            System.out.println(constructionSite.getName());
            System.out.println(constructionSite.getBuildingNumber());
            System.out.println(constructionSite.getCoordinates());
            System.out.println(constructionSite.getRealStartDate());

        }
        assertTrue(users.size()>0);
    }

    @Test
    @Transactional
    public void getUsersRoleTest()throws Exception{
        List<User> users = userJpaRepository.findAll();

        User user = users.get(1);

        Set<Role> roles = new HashSet<Role>();
        roles = user.getRoles();

        for(Role role : roles){
            System.out.println(user.getName());
            System.out.println(user.getLastName());
            System.out.println(role.getId());
            System.out.println(role.getName());

        }
        assertTrue(users.size()>0);
    }

    @Test
    @Transactional
    public void getUsersCommentsTest()throws Exception{
        List<User> users = userJpaRepository.findAll();

        User user = users.get(1);

        List<Comment> comments = user.getComments();

        for(int i=0; i<comments.size();i++){
            System.out.println(user.getName());
            System.out.println(user.getLastName());
            System.out.println(comments.get(i).getCommentNumber());
            System.out.println(comments.get(i).getText());

        }
        assertTrue(users.size()>0);
    }


}

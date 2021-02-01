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

        User user = users.get(0);

        Set<ConstructionSite> constructionSites = new HashSet<ConstructionSite>();
               constructionSites= user.getConstructionSites();

        for(ConstructionSite constructionSite : constructionSites){
            System.out.println(constructionSite.getName());
            System.out.println(constructionSite.getBuildingNumber());
            System.out.println(constructionSite.getCoordinates());
            System.out.println(constructionSite.getRealStartDate());

        }
        assertTrue(users.size()>0);
    }


}

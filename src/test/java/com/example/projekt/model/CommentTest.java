package com.example.projekt.model;

import com.example.projekt.repository.CommentJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommentTest {

    @Autowired
    private CommentJpaRepository commentJpaRepository;


    @Test
    @Transactional
    public void getComments()throws Exception{

        List<Comment> comments = commentJpaRepository.findAll();
        assertTrue(comments.size()>0);
        for(int i=0; i<comments.size();i++){

            Comment comment = comments.get(i);
            System.out.println(comment.getCommentNumber()+": "+comment.getText());
            User user = comment.getUser();
            System.out.println(user.getName()+" "+user.getLastName()+" "+user.getLogin());
            BuildingDailyReports buildingDailyReports = comment.getBuildingDailyReports();
            System.out.println(buildingDailyReports.getReportDate());

        }


    }

}

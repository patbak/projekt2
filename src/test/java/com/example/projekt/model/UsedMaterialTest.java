package com.example.projekt.model;

import com.example.projekt.repository.SalaryJpaRepository;
import com.example.projekt.repository.UsedMaterialJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class UsedMaterialTest {


    @Autowired
    private UsedMaterialJpaRepository usedMaterialJpaRepository;

    @Test
    @Transactional
    public void getUsedMaterialTest()throws Exception{

       List<UsedMaterial> usedMaterials = usedMaterialJpaRepository.findAll();
       for(UsedMaterial usedMaterial:usedMaterials){
          Material material = usedMaterial.getMaterial();
          System.out.println(
                  material.getMaterialName()+" "+material.getMaterialUnit()+" "+
                          usedMaterial.getQuantity()
          );

       }
    }
}

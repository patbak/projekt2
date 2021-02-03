package com.example.projekt.model;

import com.example.projekt.repository.MaterialJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class MaterialTest {

    @Autowired
    private MaterialJpaRepository materialJpaRepository;

    @Test
    @Transactional
    public void getMachineTest()throws Exception{
       List<Material> materials = materialJpaRepository.findAll();

       for (Material material : materials){
          System.out.println(
                  material.getMaterialName()+" "
                  +material.getMaterialUnit()+" "
                  +material.getMaterialId()
          );
          List<UsedMaterial> usedMaterials = material.getUsedMaterials();
          for(UsedMaterial usedMaterial : usedMaterials){
              System.out.println(usedMaterial.getUsedMaterialId()+" "+usedMaterial.getQuantity());
          }

       }

    }

}

package com.example.projekt.service;

import com.example.projekt.dto.MaterialDto;
import com.example.projekt.model.Material;
import com.example.projekt.repository.MaterialJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialJpaRepository materialJpaRepository;

    public List<MaterialDto> getMaterials(){
        List<Material> materials = materialJpaRepository.findAll();
        List<MaterialDto> materialDtoList = new ArrayList<>();
        for(Material material:materials){
            MaterialDto materialDto = setMaterial(material);
            materialDtoList.add(materialDto);
        }
        return materialDtoList;
    }

    public MaterialDto setMaterial(Material material){
        MaterialDto materialDto = new MaterialDto(
                material.getMaterialId(),
                material.getMaterialName(),
                material.getMaterialUnit()
        );
        return materialDto;
    }
}

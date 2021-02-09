package com.example.projekt.service;

import com.example.projekt.entity.MaterialUsedDto;
import com.example.projekt.entity.BrigadeDailyReportDto;
import com.example.projekt.entity.MaterialDto;
import com.example.projekt.model.UsedMaterial;
import com.example.projekt.repository.UsedMaterialJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialUsedService {

    @Autowired
    private BrigadeDailyReportService brigadeDailyReportService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private UsedMaterialJpaRepository usedMaterialJpaRepository;


    public List<MaterialUsedDto> getMaterialsUsed(){
       List<UsedMaterial> usedMaterials = usedMaterialJpaRepository.findAll();
        List<MaterialUsedDto> materialUsedDtoList = new ArrayList<>();

        for(UsedMaterial usedMaterial:usedMaterials){
            MaterialUsedDto materialUsedDto = setMaterialUsed(usedMaterial);
            materialUsedDtoList.add(materialUsedDto);
        }
        return materialUsedDtoList;
    }

    public MaterialUsedDto setMaterialUsed(UsedMaterial usedMaterial){
        BrigadeDailyReportDto brigadeDailyReportDto = brigadeDailyReportService.setBrigadeReport(usedMaterial.getDailyWorkReport());
        MaterialDto materialDto = materialService.setMaterial(usedMaterial.getMaterial());
        MaterialUsedDto materialUsedDto = new MaterialUsedDto(
                usedMaterial.getUsedMaterialId(),
                usedMaterial.getQuantity(),
                brigadeDailyReportDto,
                materialDto
        );
        return materialUsedDto;
    }
}

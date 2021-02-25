package com.example.projekt.service;

import com.example.projekt.dto.MaterialUsedCommandDto;
import com.example.projekt.dto.MaterialUsedDto;
import com.example.projekt.dto.BrigadeDailyReportDto;
import com.example.projekt.dto.MaterialDto;
import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.Material;
import com.example.projekt.model.UsedMaterial;
import com.example.projekt.repository.DailyWorkReportJpaRepository;
import com.example.projekt.repository.MaterialJpaRepository;
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
    @Autowired
    private DailyWorkReportJpaRepository dailyWorkReportJpaRepository;
    @Autowired
    private MaterialJpaRepository materialJpaRepository;

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

    public void createMaterialUsed(int brigadeDailyReportId, MaterialUsedCommandDto materialUsedCommandDto){

        DailyWorkReport dailyWorkReport = dailyWorkReportJpaRepository.getOne(brigadeDailyReportId);
        Material material = materialJpaRepository.getOne(materialUsedCommandDto.getMaterialId());

        UsedMaterial usedMaterial = new UsedMaterial(
                materialUsedCommandDto.getQuantity(),
                material,
                dailyWorkReport
        );
       usedMaterialJpaRepository.saveAndFlush(usedMaterial);
    }

    public void updateMaterialUsed(int brigadeDailyReportId, int materialUsedId, MaterialUsedCommandDto materialUsedCommandDto){
      UsedMaterial usedMaterial =  usedMaterialJpaRepository.getOne(materialUsedId);
      Material material = materialJpaRepository.getOne(materialUsedCommandDto.getMaterialId());
      usedMaterial.setQuantity(materialUsedCommandDto.getQuantity());
      usedMaterial.setMaterial(material);
      usedMaterialJpaRepository.saveAndFlush(usedMaterial);
    }
}

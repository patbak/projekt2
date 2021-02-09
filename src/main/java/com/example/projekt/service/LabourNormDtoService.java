package com.example.projekt.service;

import com.example.projekt.entity.LabourNormDto;
import com.example.projekt.model.LabourStandard;
import com.example.projekt.repository.LabourStandardJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabourNormDtoService {

    @Autowired
    private LabourStandardJpaRepository labourStandardJpaRepository;

    public List<LabourNormDto> getLabourNorms(){
        List<LabourStandard> labourStandards = labourStandardJpaRepository.findAll();
        List<LabourNormDto> labourNormDtoList = new ArrayList<>();
                for(LabourStandard labourStandard:labourStandards){
                    LabourNormDto labourNormDto = setLabourNorm(labourStandard);
                    labourNormDtoList.add(labourNormDto);
                }
                return labourNormDtoList;
    }

    public LabourNormDto setLabourNorm(LabourStandard labourStandard){
        LabourNormDto labourNormDto = new com.example.projekt.entity.LabourNormDto(
                labourStandard.getLabourStandardId(),
                labourStandard.getCatalogNumber(),
                labourStandard.getTableNumber(),
                labourStandard.getColumnNumber(),
                labourStandard.getRowNumber(),
                labourStandard.getWorkName(),
                labourStandard.getUnitOfMeasurementNumber(),
                labourStandard.getUnitOfMeasurementValue(),
                labourStandard.getLabourStandard()
        );
        return  labourNormDto;
    }
}

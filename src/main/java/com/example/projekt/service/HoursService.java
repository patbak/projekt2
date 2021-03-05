package com.example.projekt.service;

import com.example.projekt.dto.HoursDto;
import com.example.projekt.model.Hours;
import com.example.projekt.repository.HoursJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HoursService {

    @Autowired
    private HoursJpaRepository hoursJpaRepository;
    @Autowired
    private  BuildingService buildingService;
    @Autowired
    private WorkerService workerService;

    public HoursDto setHoursDto(Hours hours){
        HoursDto hoursDto = new HoursDto(
                hours.getIdHours(),
                hours.getHours(),
                hours.getNightHours(),
                hours.getHarmfulHours(),
                hours.getOvertime(),
                hours.getDate(),
                buildingService.setBuilding(hours.getConstructionSite()),
                workerService.setWorker(hours.getEmployee())
        );
        return hoursDto;
    }


  public List<HoursDto> getHoursByDate(LocalDate date){
        LocalDate startOfMonth = date.withDayOfMonth(1);
        LocalDate endOfMonth = date.withDayOfMonth(date.lengthOfMonth());
        List<Hours> hoursList = hoursJpaRepository.findAllByDateBetween(startOfMonth,endOfMonth);
        List<HoursDto> hoursDtoList = new ArrayList<>();

        for(Hours hours: hoursList){
            HoursDto hoursDto = setHoursDto(hours);
            hoursDtoList.add(hoursDto);
        }

        return hoursDtoList;
  }

}

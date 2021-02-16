
package com.example.projekt.service;

//import com.example.projekt.entity.LocalDateConverter;
import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.HoursJpaRepository;
import com.example.projekt.repository.TimesheetJpaRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.abs;

@Service
public class WorktimeService {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    private List<Hours> hoursList;
    private Hours hours;
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private HoursJpaRepository hoursJpaRepository;
    @Autowired
    private TimesheetJpaRepository timesheetJpaRepository;

    @Scheduled(cron = "30 9 5 * * *")
    public void countWorkTime() {
        hoursList = new ArrayList<>();
        List<Timesheet> timesheetList = timesheetService.getLastMonthTimesheets();
        for (Timesheet timesheet:timesheetList) {
            hours = new Hours();
            //dla każdej karty pracy będzie obliczać ilość godzin które upłynęły w pracy
            LocalTime startOfWork = timesheet.getStartTimeOfWork();
            LocalTime endOfWork = timesheet.getEndTimeOfWork();
            LocalDate reportDate = timesheet.getTimesheetDate();
            LocalDateTime dateTime1 = LocalDateTime.of(reportDate, startOfWork);
            LocalDateTime dateTime2 = LocalDateTime.of(reportDate, endOfWork);
            if (endOfWork.isBefore(startOfWork)) {
                dateTime2 = dateTime2.plusDays(1);
            }
            hours.addHours(countHours(dateTime1, dateTime2));
            hours.addOvertime(countOvertime(dateTime1, dateTime2));
            hours.addHarmfulHours(timesheet.getHarmfulHours());
            hours.addNightHours(countNightHours(dateTime1,dateTime2));
            hours.setEmployee(timesheet.getEmployee());
            hours.setDate(timesheet.getTimesheetDate());
            hours.setConstructionSite(timesheet.getDailyWorkReport().getConstructionSite());
            hoursList.add(hours);
        }
        hoursJpaRepository.saveAll(hoursList);
    }

    public int countHours(LocalDateTime startOfWork, LocalDateTime endOfWork) {
        int hours = 0;
        hours = (int) Duration.between(startOfWork, endOfWork).toHours();
        return hours;
    }

    public int countOvertime(LocalDateTime startOfWork, LocalDateTime endOfWork) {
        int overtime = 0;
        int worktime = (int) Duration.between(startOfWork, endOfWork).toHours();
        if (worktime > 8)
            overtime = worktime - 8;
        return overtime;

    }

    public int countNightHours(LocalDateTime startOfWork, LocalDateTime endOfWork) {
        int nightHours = 0;
        LocalDateTime temp = startOfWork.withHour(22);

        if(startOfWork.getHour()>22&&endOfWork.getHour()<6){
            nightHours = (int) Duration.between(startOfWork,endOfWork).toHours();

        }else if (startOfWork.getHour()<22&&endOfWork.getHour()<6){
            nightHours = (int) Duration.between(temp,endOfWork).toHours();
        }else if(startOfWork.getHour()>22&&endOfWork.getHour()>6){

            temp = endOfWork.withHour(6);
            nightHours = (int) Duration.between(startOfWork,temp).toHours();
        }else if(startOfWork.getHour()<22&&endOfWork.getHour()>6){

            if(startOfWork.toLocalDate().compareTo(endOfWork.toLocalDate())==-1)
            nightHours = 8;
        }else if(startOfWork.getHour()==22&&endOfWork.getHour()==6){
            nightHours=8;
        }

        return nightHours;
    }
}

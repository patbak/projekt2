
package com.example.projekt.service;

//import com.example.projekt.entity.LocalDateConverter;
import com.example.projekt.model.Employee;
import com.example.projekt.model.Hours;
import com.example.projekt.model.Timesheet;
import com.example.projekt.repository.EmployeeJpaRepository;
import com.example.projekt.repository.HoursJpaRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
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
public class WorktimeService {// oblicza czas pracy dla każdego pracownika w poszczególnym miesiacu

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    private List<Hours> hoursList = new ArrayList<>();
    private Hours hours;
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private HoursJpaRepository hoursJpaRepository;


    public void getTimesheetsToCount() {//wybiera karty pracy dla każdego pracownika z poprzedniego miesiąca
        List<Employee> employees = employeeJpaRepository.findAll();
        List<Timesheet> timesheets = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            timesheets = timesheetService.getLastMonthTimesheets(
                    employees.get(i).getEmployeeId()
            );

            countWorkTime(timesheets);

        }
        hoursJpaRepository.saveAll(hoursList);
    }

    public void countWorkTime(List<Timesheet> timesheets) {

        hours = new Hours();
        for (int i = 0; i < timesheets.size(); i++) {
            //dla każdej karty pracy będzie obliczać ilość godzin które upłynęły w pracy
            Timesheet timesheet = timesheets.get(i);
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

        }
        hours.setMonth(LocalDate.now().minusMonths(1).getMonth().name());
        hoursList.add(hours);
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

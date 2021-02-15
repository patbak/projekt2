package com.example.projekt.repository;

import com.example.projekt.model.BuildingDailyReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BuildingDailyReportsJpaRepository  extends JpaRepository<BuildingDailyReports, Integer> {

    List<BuildingDailyReports> findAllByReportDateBetweenAndConstructionSite_ConstructionSiteId(Date startOfMonth, Date endOfMonth, int id);
}

package com.example.projekt.repository;

import com.example.projekt.model.DailyWorkReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(path = "brigadeDailyReport", collectionResourceRel = "brigadeDailyReport")
public interface DailyWorkReportJpaRepository  extends JpaRepository<DailyWorkReport, Integer>
{
   List<DailyWorkReport> findAllByReportDateBetweenAndConstructionSite_ConstructionSiteId(Date startOfMonth, Date endOfMonth, int id);

  //  List<DailyWorkReport> findAllByReportDateBetweenConstructionSite_ConstructionSiteId(Date startOfMonth, Date endOfMonth, int id);
}

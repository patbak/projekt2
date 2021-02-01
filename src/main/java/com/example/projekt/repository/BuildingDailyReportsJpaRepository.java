package com.example.projekt.repository;

import com.example.projekt.model.BuildingDailyReports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingDailyReportsJpaRepository  extends JpaRepository<BuildingDailyReports, Integer> {

}

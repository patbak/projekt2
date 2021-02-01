package com.example.projekt.repository;

import com.example.projekt.model.MachineReportHasMachines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineReportHasMachinesRepository  extends JpaRepository<MachineReportHasMachines, Integer> {
}

package com.example.projekt.repository;

import com.example.projekt.model.ConstructionSite;
import com.example.projekt.model.Costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostsJpaRepository  extends JpaRepository<Costs,Integer> {

List<Costs> findAllByConstructionSite_ConstructionSiteIdOrderByDateDesc(int id);

}

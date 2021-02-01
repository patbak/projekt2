package com.example.projekt.repository;

import com.example.projekt.model.WeatherConditions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherConditionsJpaRepository extends JpaRepository<WeatherConditions, Integer> {
}

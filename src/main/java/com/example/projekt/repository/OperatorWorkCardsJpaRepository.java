package com.example.projekt.repository;

import com.example.projekt.model.OperatorWorkCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorWorkCardsJpaRepository extends JpaRepository<OperatorWorkCards, Integer> {
}
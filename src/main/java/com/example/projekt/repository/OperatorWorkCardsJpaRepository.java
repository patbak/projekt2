package com.example.projekt.repository;

import com.example.projekt.model.DailyWorkReport;
import com.example.projekt.model.OperatorWorkCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface OperatorWorkCardsJpaRepository extends JpaRepository<OperatorWorkCards, Integer> {

    List<OperatorWorkCards> findAllByWorkCardDateBetween(Date startOfMonth, Date endOfMonth);

}

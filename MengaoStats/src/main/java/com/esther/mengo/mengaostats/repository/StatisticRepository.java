package com.esther.mengo.mengaostats.repository;

import com.esther.mengo.mengaostats.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    

}

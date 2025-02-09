package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.Statistic;

import java.util.List;

public interface StatisticService {

    List<Statistic> getAllStatistics();
    Statistic getStatisticById(Long id);
    Statistic createStatistic(Statistic statistic);
    Statistic updateStatistic(Long id, Statistic statistic);
    void deleteStatistic(Long id);
}

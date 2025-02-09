package com.esther.mengo.mengaostats.service.implement;

import com.esther.mengo.mengaostats.model.Statistic;
import com.esther.mengo.mengaostats.repository.StatisticRepository;
import com.esther.mengo.mengaostats.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticServiceImpl implements StatisticService {

    private final StatisticRepository statisticRepository;

    @Autowired
    public StatisticServiceImpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    @Override
    public List<Statistic> getAllStatistics() {
        return statisticRepository.findAll();
    }

    @Override
    public Statistic getStatisticById(Long id) {
        Optional<Statistic> statistic = statisticRepository.findById(id);
        return statistic.orElseThrow(() -> new RuntimeException("Statistic not found with id: " + id));
    }

    @Override
    public Statistic createStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Override
    public Statistic updateStatistic(Long id, Statistic statistic) {
        Statistic existingStatistic = getStatisticById(id);
        existingStatistic.setGoals(statistic.getGoals());
        existingStatistic.setAssists(statistic.getAssists());
        existingStatistic.setYellowCards(statistic.getYellowCards());
        existingStatistic.setRedCards(statistic.getRedCards());
        existingStatistic.setTackles(statistic.getTackles());
        existingStatistic.setShotsOnTarget(statistic.getShotsOnTarget());
        return statisticRepository.save(existingStatistic);
    }

    @Override
    public void deleteStatistic(Long id) {
        statisticRepository.deleteById(id);
    }


}

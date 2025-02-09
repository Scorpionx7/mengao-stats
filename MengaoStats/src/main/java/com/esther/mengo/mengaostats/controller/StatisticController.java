package com.esther.mengo.mengaostats.controller;


import com.esther.mengo.mengaostats.model.Statistic;
import com.esther.mengo.mengaostats.service.StatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public ResponseEntity<List<Statistic>> getAllStatistics() {
        List<Statistic> statistics = statisticService.getAllStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistic> getStatisticById(@PathVariable Long id) {
        Statistic statistic = statisticService.getStatisticById(id);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Statistic> createStatistic(@RequestBody Statistic statistic) {
        Statistic createdStatistic = statisticService.createStatistic(statistic);
        return new ResponseEntity<>(createdStatistic, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistic> updateStatistic(@PathVariable Long id, @RequestBody Statistic statistic) {
        Statistic updatedStatistic = statisticService.updateStatistic(id, statistic);
        return new ResponseEntity<>(updatedStatistic, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistic(@PathVariable Long id) {
        statisticService.deleteStatistic(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/average-goals")
    public ResponseEntity<Double> getAverageGoalsPerGame() {
        double averageGoals = statisticService.getAverageGoalsPerGame();
        return new ResponseEntity<>(averageGoals, HttpStatus.OK);
    }

    @GetMapping("/home-vs-away")
    public ResponseEntity<Map<String, Double>> getHomeVsAwayPerformance() {
        Map<String, Double> performance = statisticService.getHomeVsAwayPerformance();
        return new ResponseEntity<>(performance, HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<Statistic> getStatisticByPlayerId(@PathVariable Long playerId) {
        Statistic statistic = statisticService.getStatisticByPlayerId(playerId);
        return new ResponseEntity<>(statistic, HttpStatus.OK);
    }


}

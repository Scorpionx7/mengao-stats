package com.esther.mengo.mengaostats.controller;


import com.esther.mengo.mengaostats.model.Statistic;
import com.esther.mengo.mengaostats.service.StatisticService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}

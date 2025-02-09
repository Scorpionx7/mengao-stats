package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.model.Competition;
import com.esther.mengo.mengaostats.service.CompetitionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/competitions")
    public ResponseEntity<List<Competition>>getAllCompetitions() {
        List<Competition> competitions = competitionService.getAllCompetitions();
        return new ResponseEntity<>(competitions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        Competition competition = competitionService.getCompetitionById(id);
        return new ResponseEntity<>(competition, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Competition> createCompetition(@RequestBody Competition competition) {
        Competition createdCompetition = competitionService.createCompetition(competition);
        return new ResponseEntity<>(createdCompetition, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        Competition updatedCompetition = competitionService.updateCompetition(id, competition);
        return new ResponseEntity<>(updatedCompetition, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

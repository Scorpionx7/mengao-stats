package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> getAllCompetitions();
    Competition getCompetitionById(Long id);
    Competition createCompetition(Competition competition);
    Competition updateCompetition(Long id, Competition competition);
    void deleteCompetition(Long id);
}

package com.esther.mengo.mengaostats.service.implement;

import com.esther.mengo.mengaostats.model.Competition;
import com.esther.mengo.mengaostats.repository.CompetitionRepository;
import com.esther.mengo.mengaostats.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }
    @Override
    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition getCompetitionById(Long id) {
        Optional<Competition> competition = competitionRepository.findById(id);
        return competition.orElseThrow(() -> new RuntimeException("Competition not found with id: " + id));
    }

    @Override
    public Competition createCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition updateCompetition(Long id, Competition competition) {
        Competition existingCompetition = getCompetitionById(id);
        existingCompetition.setName(competition.getName());
        existingCompetition.setSeason(competition.getSeason());
        return competitionRepository.save(existingCompetition);
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }


}

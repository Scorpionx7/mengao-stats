package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface GameService {
    List<Game> getGamesByCompetitionId(Long competitionId);
    Game createGame(Game game);
    Game updateGame(Long id, Game game);
    void deleteGame(Long id);
    List<Game> getAllGames();
    List<Game> getGamesByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    Page<Game> getAllGames(Pageable pageable);
}

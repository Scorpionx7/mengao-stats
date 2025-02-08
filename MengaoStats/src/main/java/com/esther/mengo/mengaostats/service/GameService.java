package com.esther.mengo.mengaostats.service;

import com.esther.mengo.mengaostats.model.Game;

import java.util.List;

public interface GameService {
    List<Game> getGamesByCompetitionId(Long competitionId);
    Game createGame(Game game);
    Game updateGame(Long id, Game game);
    void deleteGame(Long id);
}

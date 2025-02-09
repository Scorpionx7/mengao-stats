package com.esther.mengo.mengaostats.service.implement;

import com.esther.mengo.mengaostats.model.Game;
import com.esther.mengo.mengaostats.repository.GameRepository;
import com.esther.mengo.mengaostats.service.GameService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {


    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getGamesByCompetitionId(Long competitionId){
        return gameRepository.findByCompetitionId(competitionId);
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
    @Override
    public Game updateGame(Long id, Game game) {
        Optional<Game> existingGame = gameRepository.findById(id);
        if (existingGame.isPresent()) {
            Game updatedGame = existingGame.get();
            updatedGame.setHomeTeam(game.getHomeTeam());
            updatedGame.setAwayTeam(game.getAwayTeam());
            updatedGame.setDate(game.getDate());
            updatedGame.setHomeScore(game.getHomeScore());
            updatedGame.setAwayScore(game.getAwayScore());
            return gameRepository.save(updatedGame);
        } else{
            throw new RuntimeException("Game not found with id: " + id);
        }
    }

    @Override
    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }


}

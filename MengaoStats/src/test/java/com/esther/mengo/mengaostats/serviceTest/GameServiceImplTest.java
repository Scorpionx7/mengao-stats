package com.esther.mengo.mengaostats.serviceTest;

import com.esther.mengo.mengaostats.model.Competition;
import com.esther.mengo.mengaostats.model.Game;
import com.esther.mengo.mengaostats.repository.GameRepository;
import com.esther.mengo.mengaostats.service.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameServiceImplTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    public void whenGetGamesByCompetitionId_thenReturnGames() {
        // Dado
        Competition competition = new Competition("Brasileirão", "2023");
        competition.setId(1L);

        Game game1 = new Game(competition, LocalDateTime.now(), "Flamengo", "Vasco");
        game1.setId(1L);

        Game game2 = new Game(competition, LocalDateTime.now(), "Flamengo", "Fluminense");
        game2.setId(2L);

        List<Game> games = Arrays.asList(game1,game2);

        when(gameRepository.findByCompetitionId(1L)).thenReturn(games);

        // Quando
        List<Game> foundGames = gameService.getGamesByCompetitionId(1L);

        //Então
        assertThat(foundGames).hasSize(2);
        verify(gameRepository, times(1)).findByCompetitionId(1L);
    }

    @Test
    public void whenCreateGame_thenReturnSavedGame() {
        //Dado
        Game game = new Game(null, LocalDateTime.now(), "Flamengo", "Vasco");
        when(gameRepository.save(game)).thenReturn(game);

        //Quando
        Game savedGame = gameService.createGame(game);

        //Então
        assertThat(savedGame.getHomeTeam()).isEqualTo("Flamengo");
        verify(gameRepository, times(1)).save(game);
    }

    @Test
    public void whenUpdateGame_thenReturnUpdatedGame() {
        // Dado
        Game existingGame = new Game(null, LocalDateTime.now(), "Flamengo", "Vasco");
        existingGame.setId(1L);

        Game updatedGame = new Game(null, LocalDateTime.now(), "Flamengo", "Fluminense");

        when(gameRepository.findById(1L)).thenReturn(Optional.of(existingGame));
        when(gameRepository.save(existingGame)).thenReturn(existingGame);

        // Quando
        Game result = gameService.updateGame(1L, updatedGame);

        // Então
        assertThat(result.getAwayTeam()).isEqualTo("Fluminense");
        verify(gameRepository, times(1)).findById(1L);
        verify(gameRepository, times(1)).save(existingGame);
    }

    @Test
    public void whenDeleteGame_thenRepositoryMethodCalled() {
        //Quando
        gameService.deleteGame(1L);

        // Então
        verify(gameRepository, times(1)).deleteById(1L);
    }
}

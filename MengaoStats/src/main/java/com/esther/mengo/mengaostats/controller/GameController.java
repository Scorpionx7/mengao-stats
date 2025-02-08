package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.model.Game;
import com.esther.mengo.mengaostats.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/competition/{competitionId}")
    public ResponseEntity<List<Game>> getGamesByCompetitionId(@PathVariable Long competitionId) {
        List<Game> games = gameService.getGamesByCompetitionId(competitionId);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        Game createdGame = gameService.createGame(game);
        return new ResponseEntity<>(createdGame, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@RequestBody Game game, @PathVariable Long id) {
        Game updateGame = gameService.updateGame(id,game);
        return new ResponseEntity<>(updateGame, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

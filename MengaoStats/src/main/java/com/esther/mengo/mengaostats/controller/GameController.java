package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.model.Game;
import com.esther.mengo.mengaostats.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/games")
@Tag(name = "Games", description = "Operações relacionadas a jogos")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.getAllGames();
        if (games.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(games);
    }

    @GetMapping("/competition/{competitionId}")
    public ResponseEntity<?> findGamesByCompetitionId(@PathVariable Long competitionId) {
        List<Game> games = gameService.getGamesByCompetitionId(competitionId);
        if (games.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No games found for competition ID: " + competitionId);
        }
        return ResponseEntity.ok(games);
    }

    @PostMapping
    public ResponseEntity<?> createGame(@RequestBody Game game) {
        // Validação simples de exemplo
        if (game == null || game.getHomeTeam() == null || game.getAwayTeam() == null) {
            return ResponseEntity.badRequest().body("Invalid game data. Please check the payload.");
        }
        Game createdGame = gameService.createGame(game);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/api/games/" + createdGame.getId())
                .body(createdGame);
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

    @GetMapping("/date-range")
    public ResponseEntity<List<Game>> getGamesByDateRange(
            @RequestParam LocalDateTime startDate,
            @RequestParam LocalDateTime endDate) {
        List<Game> games = gameService.getGamesByDateRange(startDate, endDate);
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Game>> getPagedGames(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Game> games = gameService.getAllGames(PageRequest.of(page, size));
        return new ResponseEntity<>(games, HttpStatus.OK);
    }


}

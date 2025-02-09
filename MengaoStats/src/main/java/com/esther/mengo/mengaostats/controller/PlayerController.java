package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.model.Player;
import com.esther.mengo.mengaostats.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id){
        Player player = playerService.getPlayerId(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player){
        Player playerCreated = playerService.createPlayer(player);
        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player){
        Player updatePlayer = playerService.updatePlayer(player, id);
        return new ResponseEntity<>(updatePlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/top-scorer")
    public ResponseEntity<Player> getTopScorer() {
        Player topScorer = playerService.getTopScorer();
        return new ResponseEntity<>(topScorer, HttpStatus.OK);
    }

    @GetMapping("/top-assister")
    public ResponseEntity<Player> getTopAssister() {
        Player topAssister = playerService.getTopAssister();
        return new ResponseEntity<>(topAssister, HttpStatus.OK);
    }
}

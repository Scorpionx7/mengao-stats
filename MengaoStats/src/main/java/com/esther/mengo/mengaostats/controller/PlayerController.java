package com.esther.mengo.mengaostats.controller;

import com.esther.mengo.mengaostats.dto.PlayerDTO; // Importe o DTO
import com.esther.mengo.mengaostats.model.Player;
import com.esther.mengo.mengaostats.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        // Converte a lista de entidades para uma lista de DTOs
        List<PlayerDTO> playerDTOs = players.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDTOs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable Long id){
        Player player = playerService.getPlayerId(id);
        return new ResponseEntity<>(convertToDto(player), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO){
        // Converte o DTO recebido para uma entidade
        Player player = convertToEntity(playerDTO);
        Player playerCreated = playerService.createPlayer(player);
        // Converte a entidade criada de volta para DTO para retornar na resposta
        return new ResponseEntity<>(convertToDto(playerCreated), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO){
        Player player = convertToEntity(playerDTO);
        Player updatedPlayer = playerService.updatePlayer(player, id);
        return new ResponseEntity<>(convertToDto(updatedPlayer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/top-scorer")
    public ResponseEntity<PlayerDTO> getTopScorer() {
        Player topScorer = playerService.getTopScorer();
        return new ResponseEntity<>(convertToDto(topScorer), HttpStatus.OK);
    }

    @GetMapping("/top-assister")
    public ResponseEntity<PlayerDTO> getTopAssister() {
        Player topAssister = playerService.getTopAssister();
        return new ResponseEntity<>(convertToDto(topAssister), HttpStatus.OK);
    }

    // --- MÉTODOS AUXILIARES PARA CONVERSÃO ---

    /**
     * Converte uma entidade Player para PlayerDTO.
     */
    private PlayerDTO convertToDto(Player player) {
        // Usamos o construtor gerado pelo record
        return new PlayerDTO(
                player.getId(),
                player.getName(),
                player.getPosition(),
                player.getAge(),
                player.getNumber(),
                player.getGoals(),
                player.getAssists()
        );
    }

    /**
     * Converte um PlayerDTO para uma entidade Player.
     */
    private Player convertToEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        // Usamos os métodos de acesso gerados (ex: playerDTO.name())
        player.setName(playerDTO.name());
        player.setPosition(playerDTO.position());
        player.setAge(playerDTO.age());
        player.setNumber(playerDTO.number());
        player.setGoals(playerDTO.goals());
        player.setAssists(playerDTO.assists());
        return player;
    }
}